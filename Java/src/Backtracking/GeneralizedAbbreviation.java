package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/15/16.
 */
public class GeneralizedAbbreviation { // MARK!!
    public List<String> generateAbbreviations(String word) {
        List<String> rst = new ArrayList<>();
        abbreDFS(rst,new StringBuilder(),word.toCharArray(),0,0);
        return rst;

    }

    public void abbreDFS(List<String> rst, StringBuilder sb, char[] c, int pos, int num) {
        int len = sb.length();// decision point
        if(pos == c.length) {
            if(num != 0) sb.append(num);
            rst.add(sb.toString());
        } else {
            abbreDFS(rst, sb, c, pos + 1, num + 1);               // abbr c[i]
            System.out.println(">>>>>>>>" + sb.toString());
            System.out.println("pos:" + pos);
            System.out.println("num:" + num);
            if(num != 0) sb.append(num);
            sb.append(c[pos]);// not abbr c[i]
            abbreDFS(rst, sb, c, pos + 1, 0);
        }
        sb.setLength(len);// similar usage to deleteCharAt
        // reset to decision point
    }
    public static void main(String[] argu) {
        GeneralizedAbbreviation test = new GeneralizedAbbreviation();
        String word = "word";
        List<String> rst = test.generateAbbreviations(word);
        System.out.println(rst);
    }
}

//["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]