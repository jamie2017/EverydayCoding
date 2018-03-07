package TwoPointer;

import java.util.Arrays;

/**
 * Created by JMYE on 9/4/16.
 */
public class SortColors {
    public void sortColors(int[] nums) {


        if (nums == null || nums.length < 2) return;
        int low = 0, high = nums.length - 1;
        int i = 0;
        while(i <= high) {
            if(nums[i] == 0) {
                swap(nums,low, i);
                low++;
                i++; // note
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums,high,i);
                high--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void swapString(String[] a, int i, int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public void sortColorsPoketGem(String[] input) {
        if (input == null || input.length < 3) {
            return;
        }
        int low = 0, high = input.length - 1;
        int i = 0;
        while (i <= high) {
            if (input[i].equals("red")) {
                swapString(input,low,i);
                low ++;
                i++;
//            } else if (input[i].equals("green")) {
//                i++;
            } else if (input[i].equals("blue")) {
                swapString(input,high,i);
                high--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        SortColors test = new SortColors();

        int[] nums= {1,0,0,2,2,0,2};
        test.sortColors(nums);
        for(int n: nums) {
            System.out.print(n + " ");
        }
        System.out.println();
        String[] input= {"red","yellow","blue","green","gray","green","red"};
        test.sortColorsPoketGem(input);
        System.out.println(Arrays.asList(input));


    }
}
