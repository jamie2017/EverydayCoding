package Math;

/**
 * Created by JMYE on 8/28/16.
 */
// 168. Excel Sheet Column Title
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
}
