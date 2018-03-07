package HashTable;

/**
 * Created by JMYE on 9/26/16.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic1(String num) {
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!"11 88 696 00".contains(num.charAt(i)+""+num.charAt(j))){
                return false;
            }
        }
        return true;
    }
}
