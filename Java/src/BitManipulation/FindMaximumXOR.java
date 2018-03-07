package BitManipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JMYE on 11/20/16.
 */
public class FindMaximumXOR {
    public static int findMaximumXOR(int[] nums) {
        /*

        a ^ b = c
        a ^ c = b
        b ^ c = a
         */
        int max = 0, mask = 0;
        for(int i = 30; i >= 0; i--){
            mask = mask | (1 << i);
            System.out.println("mask"+Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                System.out.println( "set: "+ Integer.toBinaryString(num & mask));
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            System.out.println("tmp "+ Integer.toBinaryString(tmp));
            for(int prefix : set){
                System.out.println("check " + Integer.toBinaryString(tmp ^ prefix));
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    System.out.println(">>>>>>>>>>>>>>>>>max " + Integer.toBinaryString(max));
                    break;
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,9,5};
        System.out.println("result: " + Integer.toBinaryString(findMaximumXOR(nums)));
        // 5 ^ 25 = 28
    }
}
