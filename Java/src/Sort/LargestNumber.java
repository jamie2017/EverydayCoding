package Sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by JMYE on 9/21/16.
 */
public class LargestNumber {
    private Comparator<String> NumberComparator = new Comparator<String>(){
        public int compare(String s1, String s2) {

            return  (s2 + s1).compareTo(s1 + s2);
        }
    };
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length;i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, NumberComparator);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String rst = sb.toString();
        int index = 0;
        // for cases like [0,0] >> output: "0"
        while (index < rst.length() && rst.charAt(index) == '0') {
            index++;
        }
        if (index == rst.length()) {
            return "0";
        }
        return rst.substring(index);
    }
    // python one line
    // return ''.join(sorted(itertools.imap(str,num), cmp=lambda x,y:cmp(y+x, x+y))).lstrip('0') or '0'
}
