package TwoPointer;

/**
 * Created by JMYE on 8/28/16.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int rst = 0;
        if (left >= right) {
            return rst;
        }
        int leftHeight = height[left];
        int rightHeight = height[right];
        while (left < right) {
            if (leftHeight < rightHeight) {
                left ++;
                if (leftHeight > height[left]) {
                    rst += (leftHeight - height[left]);
                } else {
                    leftHeight = height[left];
                }
            } else {
                right --;
                if (rightHeight > height[right]) {
                    rst += (rightHeight - height[right]);
                } else {
                    rightHeight = height[right];
                }
            }
        }
        return rst;
    }
}

//// Version 2
//public class Solution {
//    /**
//     * @param heights: an array of integers
//     * @return: a integer
//     */
//    public int trapRainWater(int[] heights) {
//        if (heights.length == 0) {
//            return 0;
//        }
//
//        int[] maxHeights = new int[heights.length + 1];
//        maxHeights[0] = 0;
//        for (int i = 0; i < heights.length; i++) {
//            maxHeights[i + 1] = Math.max(maxHeights[i], heights[i]);
//        }
//
//        int max = 0, area = 0;
//        for (int i = heights.length - 1; i >= 0; i--) {
//            area += Math.min(max, maxHeights[i]) > heights[i]
//                    ? Math.min(max, maxHeights[i]) - heights[i]
//                    : 0;
//            max = Math.max(max, heights[i]);
//        }
//
//        return area;
//    }
//}