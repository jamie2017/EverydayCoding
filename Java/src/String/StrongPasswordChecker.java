package String;

import java.util.*;

/**
 * Created by JMYE on 11/5/16.
 */

//http://bookshadow.com/weblog/2016/10/21/leetcode-strong-password-checker/
public class StrongPasswordChecker {

    public static class Tuple{
        int mod;
        int repeat;
        public Tuple(int mod, int repeat) {
            this.mod = mod;
            this.repeat = repeat;
        }
    }
    public static int strongPasswordChecker(String s) {

        if (s == null || s.length() == 0) return 6;

        int totalCnt = s.length();
        boolean hasLowers = false;
        boolean hasUppers = false;
        boolean hasDigits = false;
        int typeCnt = 0;
        int repeatFlag = 1;
        char prev = s.charAt(0);
        List<Integer> repeats = new ArrayList<>();
        for (int i = 0; i < totalCnt; i++) {
            if (Character.isLowerCase(s.charAt(i)) && !hasLowers) {
                hasLowers = true;
                typeCnt++;
            } else if (Character.isUpperCase(s.charAt(i)) && !hasUppers) {
                hasUppers = true;
                typeCnt++;
            } else if (Character.isDigit(s.charAt(i)) && !hasDigits) {
                hasDigits = true;
                typeCnt++;
            }

            if (i > 0) {
                if (s.charAt(i) == prev) {
                    repeatFlag++;
                } else {
                    if (repeatFlag >= 3) {
                        repeats.add(repeatFlag);
                    }
                    prev = s.charAt(i);
                    repeatFlag = 1;
                }
            }
            if (i == totalCnt - 1) {
                if (repeatFlag >= 3) {
                    repeats.add(repeatFlag);
                }
            }
        }
        System.out.println(repeats);
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.mod - o2.mod;
            }
        });
        int maxRepeat = 0;
        for (int rep: repeats) {
            maxRepeat = Math.max(maxRepeat,rep);
            pq.offer(new Tuple(rep%3, rep));
        }



        if (totalCnt < 6) {
            if (maxRepeat == 5) {
                return Math.max(2, 3 - typeCnt);
            }
            return Math.max(6 - totalCnt, 3 - typeCnt);
        }
        int deleteCnt = Math.max(totalCnt - 20, 0);

        while (totalCnt > 20 && !pq.isEmpty()) {
            Tuple tmp = pq.poll();
            int delta = Math.min(tmp.mod + 1, totalCnt - 20);
            totalCnt -= delta;
            pq.offer(new Tuple(2, tmp.repeat - delta));
        }

        int changeCnt = 0;
        while(!pq.isEmpty()) {
            changeCnt += pq.poll().repeat / 3;
        }

        return deleteCnt + Math.max(changeCnt, 3 - typeCnt);
    }

    public static void main(String[] args) {
        String s = "aaabbaaabbbccc";
        System.out.println(strongPasswordChecker(s));
    }
}
