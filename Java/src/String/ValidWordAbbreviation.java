package String;

/**
 * Created by JMYE on 10/4/16.
 */
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation_re(String word, String abbr) {
        return word.matches(abbr.replaceAll("[1-9]\\d*", ".{$0}"));
    }
    // "i12iz4n" into a regular expression like "i.{12}iz.{4}n"


    //
    public boolean validWordAbbreviation(String word, String abbr) {
        // Character.isDigit
        // Character.isLetter
        // Character.getNumericValue(c)
        int abrCnt = 0;
        int prevMatchIdx = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            if (Character.isLetter(c)) {
                if (abrCnt != 0) {
                    prevMatchIdx += abrCnt;
                }
                if (prevMatchIdx >= word.length() || c != word.charAt(prevMatchIdx)) {
                    return false;
                }
                prevMatchIdx += 1;
                abrCnt = 0;
            } else {
                if (abrCnt == 0 && c == '0') {
                    return false;
                }
                abrCnt = abrCnt * 10 + Character.getNumericValue(c);
            }
        }
        return prevMatchIdx + abrCnt == word.length();
    }
}
