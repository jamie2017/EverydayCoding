package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JMYE on 9/16/16.
 */
public class PalindromePairs {
    /*
    1. use hashmap map.put(words[i],i)

    2. for each word[i]: if (word[i].substring(0,j)) is a valid palindrome
    find if map.containsKey(reverse(word[i].substring(j))) && its index != i
    if Yes, the add (i, map.get()) as a palindrome pair

    3. apply to reverse order , because  palindrome is symmetric

     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> rst = new ArrayList<>();
        if (words == null || words.length < 2) {
            return rst;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],i);
        }
        for(int i = 0; i < words.length; i++){
            for (int j = 0; j <= words[i].length(); j++) { // <= Consider the test case of ["a", ""]
                String str1 = words[i].substring(0,j);
                String str2 = words[i].substring(j);
                addPair(map,rst,str1,str2,i,false);
                if(str2.length() != 0) { // avoid duplicates
                    addPair(map,rst,str2,str1,i,true);
                }

            }
        }
        return rst;


    }

    private void addPair(Map<String, Integer> map, List<List<Integer>> rst, String str1, String str2,int index, boolean reverse) {
        if (isPalindrome(str1)) {
            String str2rev = new StringBuilder(str2).reverse().toString();
            if (map.containsKey(str2rev) && map.get(str2rev) != index) {
                List<Integer> list = new ArrayList<>();
                if (!reverse) {
                    list.add(map.get(str2rev)); // !!
                    list.add(index);
                } else {
                    list.add(index);
                    list.add(map.get(str2rev));
                }
                rst.add(list);
            }
        }

    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }

    public static void main (String[] argu) {
        PalindromePairs test = new PalindromePairs();
        String[] words = {"abcd","dcba","dcb"};
        test.palindromePairs(words);
    }
}
