package ByComs.Marketo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 2/20/17.
 */
public class BuildSubSet {
    public List<String> buildSubset(String str){
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        subsetHelper(result, new StringBuilder(), strArray, 0);
        return result;

    }

    private void subsetHelper(List<String> result, StringBuilder sb, char[] strArray, int pos) {
        result.add(sb.toString());
        for (int i = pos; i < strArray.length; i++) {
            sb.append(strArray[i]);
            subsetHelper(result, sb, strArray,i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        BuildSubSet test = new BuildSubSet();
        List<String> res = test.buildSubset("abc");
        System.out.println(res);
    }
}

