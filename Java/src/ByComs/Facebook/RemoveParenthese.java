package ByComs.Facebook;

/**
 * Created by JMYE on 8/23/17.
 */
public class RemoveParenthese {
    public static String fix(String str) {
        StringBuffer res = new StringBuffer(str);
        int l = 0, r = 0;
        int i = 0;
        while (i < res.length()) {
            if (res.charAt(i) == '(') l++;
            else if (res.charAt(i) == ')'){
                if (l <= r) {
                    res.deleteCharAt(i);
                    i--;
                }
                else {
                    r++;
                }
            }
            i++;
        }
//        System.out.println(res.toString());
        l = 0;
        r = 0;
        i = res.length()-1;
        while (i >= 0) {
            if (res.charAt(i) == ')') r++;
            else if (res.charAt(i) == '(') {
                if (l >= r) {
                    res.deleteCharAt(i);
                }
                else {
                    l++;
                }
            }
            i--;
        }

        return res.toString();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(fix(")((())("));
        System.out.println(fix("(a)())()"));
        System.out.println(fix("((("));
        System.out.println(fix("(())("));
        System.out.println(fix("((((()((()"));
        System.out.println(fix("())))))()))"));
        System.out.println(fix("(((((((("));


    }
}
