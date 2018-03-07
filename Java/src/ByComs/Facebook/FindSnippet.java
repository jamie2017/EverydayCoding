package ByComs.Facebook;

import java.util.*;

public class FindSnippet {
    public String shortestSnippet(String s, String query) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if (!indexMap.containsKey(s.charAt(i))) {
                indexMap.put(s.charAt(i), new ArrayList<>());
            }
            indexMap.get(s.charAt(i)).add(i);
        }
        List<List<Integer>> qList = new ArrayList<>();
        for (char q: query.toCharArray()) {
            qList.add(indexMap.get(q));
        }
        if (query.length() == 1){
            if (s.contains(query)) return query;
            return "";
        }
        int[] snippet = new int[2];
        int[] min_dist = {s.length()};
        List<Integer> validIndexs = new ArrayList<>();
        snippetHelper(qList,0,validIndexs,snippet,min_dist);
        StringBuilder ans = new StringBuilder();
        for (int i = snippet[0]; i <= snippet[1]; i++) {
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }

    private void snippetHelper(List<List<Integer>> qList, int qIndex, List<Integer> validIndexs,int[] snippet,int[] min_dist) {
        if (validIndexs.size() == qList.size()) {
            if (validIndexs.get(qIndex - 1) - validIndexs.get(0) < min_dist[0]) {
                min_dist[0] = validIndexs.get(qIndex - 1) - validIndexs.get(0);
                snippet[0] = validIndexs.get(0);
                snippet[1] = validIndexs.get(qIndex - 1);
            }
            return;
        }
        for (int i = 0; i < qList.get(qIndex).size(); i++) {
            int cur = qList.get(qIndex).get(i);
            if (!validIndexs.isEmpty() && validIndexs.get(validIndexs.size() - 1) >= cur) {
                continue;
            }
            validIndexs.add(cur);
            snippetHelper(qList,qIndex + 1,validIndexs,snippet,min_dist);
            validIndexs.remove(qIndex);
        }
    }


    public String shortestSnippetBF(String s, String query) {
        if (s == null || query == null || s.length() == 0 || query.length() == 0) {
            return "";
        }
        int minLen = s.length();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == query.charAt(0)) {
                int subseqLen = findSubsequence(s.substring(i),query);
                if (subseqLen != -1) {
                    if (subseqLen < minLen) {
                        minLen = subseqLen;
                        start = i;
                    }
                }
            }
        }
        return start == -1? "" : s.substring(start, start + minLen + 1);
    }

    public int findSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j ++;
                if (j == t.length()) {
                    return i;
                }
            }
            i ++;
        }
        return -1;
    }



    public  String findMinWindow(String s, String t) { //
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){ // O(s.length())
            if (!indexMap.containsKey(s.charAt(i))) {
                indexMap.put(s.charAt(i), new ArrayList<>());
            }
            indexMap.get(s.charAt(i)).add(i);
        }
        List<List<Integer>> tList = new ArrayList<>();
        int[] validIdxs = new int[t.length()];
        // validIdxs[i] = j : valid match of t.charAt(i) at j in s, (valid here means reserve same relative order as in t)
        for (int i = 0; i < t.length(); i++) { // O(t.length())
            if ( indexMap.get(t.charAt(i)) == null) {
                return "";
            }
            validIdxs[i] = 0;
            tList.add(indexMap.get(t.charAt(i)));
        }

        boolean found = false;
        int start = 0;
        int end = 0;
        int minwindow = Integer.MAX_VALUE;
        /* Time complexity of this part is O(s.length()) ~ till we exhaust
         * any of the index arrays. */
        int i = 0;
        while (true) {
            if (i > 0) {
                /* Ensure characters appear in same order as they appear in T */
                while (validIdxs[i] < tList.get(i).size() && tList.get(i).get(validIdxs[i]) <= tList.get(i-1).get(validIdxs[i-1])) {
                    validIdxs[i]++;
                }
            }

            /* If any of the index arrays is exhausted, we do not need to
             * search anymore */
            if (validIdxs[i] == tList.get(i).size()) {
                break;
            }

            /* We have found a candidate window */
            if (i == t.length()-1) {

                /* Current window is less than minimum */
                if (tList.get(i).get(validIdxs[i]) - tList.get(0).get(validIdxs[0]) < minwindow) {
                    start = tList.get(0).get(validIdxs[0]);
                    end = tList.get(i).get(validIdxs[i]);
                    minwindow = end - start;
                    found = true;
                }
                /* Try to minimize the window */
                validIdxs[0]++;
            }
            i = (i+1)%t.length();
        }

        if (found) {
            return s.substring(start, end+1);
        }
        else
            return null;
    }

    public static void main(String[] args) {
        FindSnippet test = new FindSnippet();
        String s = "ABCABCDEC";
//                  012345678
        System.out.println(test.shortestSnippetBF(s,"CE"));// CDE
        System.out.println(test.shortestSnippetBF(s,"BD")); // BCD
        System.out.println(test.shortestSnippetBF(s,"BA")); // BCA
        System.out.println(test.shortestSnippetBF(s,"ABC")); // ABC
        System.out.println(test.shortestSnippetBF(s,"BCE")); // BCDE
        System.out.println(test.shortestSnippetBF(s,"B")); // B
        System.out.println(test.shortestSnippetBF(s,"CC")); // CABC
        System.out.println(test.shortestSnippetBF(s,"CCD")); // CABCD
        System.out.println(test.shortestSnippetBF(s,"KK")); // ""
        System.out.println(test.shortestSnippetBF(s,"")); // ""

        System.out.println(test.findMinWindow(s,"CE")); // "CDE
        System.out.println(test.findMinWindow(s,"BD")); // BCD
        System.out.println(test.findMinWindow(s,"BA")); // BCA
        System.out.println(test.findMinWindow(s,"ABC")); // ABC
        System.out.println(test.findMinWindow(s,"BCE")); // BCDE
        System.out.println(test.findMinWindow(s,"B")); // B
        System.out.println(test.findMinWindow(s,"CC")); // CABC
        System.out.println(test.findMinWindow(s,"CCD")); // CABCD
        System.out.println(test.findMinWindow(s,"KK")); // ""
        System.out.println(test.findMinWindow(s,"")); // ""

        s = "UAXSSXSXAAUB";
        System.out.println(test.findMinWindow(s,"XXA")); // XSXA
        System.out.println(test.shortestSnippetBF(s,"XXA")); // ""


    }
}
