package DP;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 12/20/16.
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int n = maxChoosableInteger;
        if ((1 + n)*n/2 < desiredTotal) {
            return false;
        }
        int[]  chooseList = new int[maxChoosableInteger];
        for(int i = 0; i < n; i++) {
            chooseList[i] = i + 1;
        }
        Map<String,Boolean> memo = new HashMap<>();
        return helper(chooseList, memo, desiredTotal);
    }

    private boolean helper(int[] chooseList, Map<String,Boolean> memo, int desiredTotal) {
        String hashKey = Arrays.toString(chooseList);
        if (memo.containsKey(hashKey)) {
            return memo.get(hashKey);
        }

        if (chooseList[chooseList.length - 1] >= desiredTotal) {
            return true;
        }

        for (int i = 0; i < chooseList.length; i++) {
             int[] left = Arrays.copyOfRange(chooseList, 0, i);
             int[] right = Arrays.copyOfRange(chooseList, i + 1, chooseList.length);
             int[] join = concatArray(left, right);
             if (!helper(join,memo, desiredTotal - chooseList[i])) {
                memo.put(hashKey,true);
                return true;
            }
        }
        memo.put(hashKey, false);
        return false;
    }


    private int[] concatArray(int[] l, int[] r) {
        int lSize = l.length;
        int rSize = r.length;
        int[] join = new int[lSize + rSize];
        for (int i = 0; i < lSize;i++) {
            join[i] = l[i];
        }
        for (int j = lSize; j < lSize + rSize; j++) {
            join[j] = r[j - lSize];
        }
        return join;
    }
}
