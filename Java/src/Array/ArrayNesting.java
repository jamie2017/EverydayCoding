package Array;

/**
 * Created by JMYE on 7/11/17.
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) { // O(n) O(n)
        boolean[] visited = new boolean[nums.length];
        int nestSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i];
                int size = 0;
                while(true) {
                    start = nums[start];
                    size ++;
                    visited[start] = true;
                    if (start == nums[i]) {
                        break;
                    }
                }
                nestSize = Math.max(nestSize, size);
            }
        }
        return nestSize;
    }

    public int arrayNestingOpt(int[] nums) { // O(n) O(1)
        int nestSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            }
            int start = nums[i];
            int size = 0;
            while(true) {
                start = Math.abs(nums[start]);
                size ++;
                nums[start] *= -1;
                if (start == Math.abs(nums[i])) {
                    break;
                }
            }
            nestSize = Math.max(nestSize, size);
        }
        return nestSize;
    }


    public static void main(String[] args) {
        ArrayNesting test = new ArrayNesting();
        int[] A = {5,4,0,3,1,6,2};
        System.out.println(test.arrayNesting(A));
        System.out.println(test.arrayNestingOpt(A));
    }
}
