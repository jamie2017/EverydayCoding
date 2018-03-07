package ByComs.GoDaddy;

import java.util.*;

/**
 * Created by JMYE on 9/29/16.
 */
public class SubSequence {
    public String[] subSequence(String s) {
        char[] sChar = s.toCharArray();
        Set<String> rst = new HashSet<>();

        subSeqHelper(rst,new StringBuilder(),sChar,0);
        String[] rstArr = rst.toArray(new String[0]);

        Arrays.sort(rstArr);
        return rstArr;
    }
    private void subSeqHelper (Set<String> rst, StringBuilder sb, char[] sChar, int pos) {
        if (sb.length() != 0) {
            rst.add(new String(sb));
        }
        for (int i = pos; i < sChar.length; i++) {
            sb.append(sChar[i]);
            subSeqHelper(rst,sb,sChar,i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        SubSequence test = new SubSequence();
        String s = "aab";
        String[] str = test.subSequence(s);
        for (String rs : str) {
            System.out.println(rs);
        }

    }
}
