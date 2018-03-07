package TwoPointer;

/**
 * Created by JMYE on 9/29/16.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= firstMin) firstMin = num;
            else if (num <= secondMin) secondMin = num;
            else if (num > secondMin) return true;
        }
        return false;
    }
}
