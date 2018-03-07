package Math;

/**
 * Created by JMYE on 8/28/16.
 */

// 171. Excel Sheet Column Number
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int colNum = 0;
        for (int i = 0; i < s.length(); i++) {
            colNum = colNum * 26 + (s.charAt(i) - 'A' + 1);
        }
        return colNum;
    }

     // python : return reduce(lambda x, y : x * 26 + y, [ord(c) - 64 for c in list(s)])
}
