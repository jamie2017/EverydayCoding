package Stack;

import java.util.Stack;

/**
 * Created by JMYE on 9/25/16.
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        // use stack s to store the index of height for which value larger than previous one
        int maxArea = 0;
        for(int i = 0; i <= len; i++){// since it will loop over last index when i == len, thus use "<=" here
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                int tmpRectan = height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()); //  i - 1 to locate the index of tp
                // test case 1: 2,6,10,3,8,6,10
                // test case 2: 4,6,2,8,9,6,7,9
                System.out.println(tmpRectan);
                maxArea = Math.max(maxArea, tmpRectan);
                i--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
//        int[] height = {2,1,5,6,2,3};
        int[] height = {1,4,3,2,2,1,9};
        LargestRectangleinHistogram test = new LargestRectangleinHistogram();
        System.out.println(test.largestRectangleArea(height));
    }
}
