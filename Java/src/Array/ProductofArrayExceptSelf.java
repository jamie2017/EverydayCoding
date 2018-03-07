package Array;

/**
 * Created by JMYE on 9/3/16.
 */
public class ProductofArrayExceptSelf { // MARK

    /*
    Two pass:  nums = [1 2 3 4]
    1) rst[i]  = products before nums[i] [1,     1,    1*2, 1*2*3]
    2) rst[i] = products after nums[i]   [2*3*4, 3*4,  4,   1    ]
    3) product together


     */
    public int[] productExceptSelf(int[] nums) {
        // nums = [1,2,3,4]
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // rst = [1,1*1,1*2,2*3] = [1,1,2,6]
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right; //6 2*4 1*4*3 1*4*3*2
            right *= nums[i];//4 4*3 4*3*2 4*3*2*1
        }

        return res;
    }
}
