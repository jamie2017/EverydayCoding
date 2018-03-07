package Array;

/**
 * Created by JMYE on 6/7/16.
 */
public class RotateArray {

    // Solution 1
    public static void rotate(int[] arr, int order) {
        if (arr == null || arr.length==0 || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        if(order > arr.length){
            order = order %arr.length;
        }

        //length of first part
        int a = arr.length - order;

        reverse(arr, 0, a-1);
        reverse(arr, a, arr.length-1);
        reverse(arr, 0, arr.length-1);

    }
    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1)
            return;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] argu) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        RotateArray test = new RotateArray();
        test.rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}