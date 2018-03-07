package TwoPointer;

/**
 * Created by JMYE on 9/3/16.
 */
public class ContainerWithMostWater {
    int computeArea(int left, int right,  int[] heights) {
        return (right-left)*Math.min(heights[left], heights[right]);
    }

    public int maxArea(int[] heights) {
        // write your code here
        int left = 0, ans=  0 ;
        int right = heights.length - 1;
        while(left <= right) {
            ans = Math.max(ans,computeArea(left, right, heights));
            if(heights[left]<=heights[right])
                left++;
            else
                right--;
        }
        return ans;
    }
}

/*

 --------------------------------------


public class Solution {
    // for any i, the maxium area will be the farthest j that has a[j] > a[i];
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length -1;
        while(left < right) {
            max = Math.max( max, (right - left) * Math.min(height[left], height[right]));
            if(height[left] <= height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;

    }
}
 */
