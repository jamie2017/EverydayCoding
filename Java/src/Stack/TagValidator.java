package Stack;

import java.util.Stack;

/**
 * Created by JMYE on 7/2/17.
 */
public class TagValidator {
    // check <![CDATA[ first then </ then <
    public boolean isValid(String code) {
        Stack<String> stk = new Stack<>();
        int i = 0;
        while (i < code.length()) {
            if (i > 0 && stk.isEmpty()) return false;
            if (code.startsWith("<![CDATA[",i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0) return false;
                i += 3;
            } else if (code.startsWith("</",i)) {
                int j = i + 2;
                i = code.indexOf('>',j);
                if (i < 0 || i == j || i - j > 9) return false;
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s =  code.substring(j, i++);
                if (stk.isEmpty() ||!stk.pop().equals(s)) return false;
            } else if (code.startsWith("<",i)) {
                int j = i + 1;
                i = code.indexOf('>',j);
                if (i < 0 || i == j || i - j > 9) return false;
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                stk.push(s);
            } else {
                i++;
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        TagValidator test = new TagValidator();
        String code1 = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
        System.out.println(test.isValid(code1)); // true
        String code2 = "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>";
        System.out.println(test.isValid(code2));// true
        String code3 = "<A>  <B> </A>   </B>";
        System.out.println(test.isValid(code3)); // false
        String code4 = "<DIV>  div tag is not closed  <DIV>";
        System.out.println(test.isValid(code4));
        String code5 = "<DIV>  unmatched <  </DIV>";
        System.out.println(test.isValid(code5));
        String code6 = "<DIV> closed tags with invalid tag name  <b>123</b> </DIV>";
        System.out.println(test.isValid(code6));
        String code7 = "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>";
        System.out.println(test.isValid(code7));
        String code8 = "<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>";
        System.out.println(test.isValid(code8));



    }
}
