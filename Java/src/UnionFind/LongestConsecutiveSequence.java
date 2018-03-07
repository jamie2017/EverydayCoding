package UnionFind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by JMYE on 9/21/16.
 */
public class LongestConsecutiveSequence { // SMART!!

    public int longestConsecutiveBest(int[] nums) { // best solution
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLCS = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int m = n + 1;
                while (set.contains(m)) {
                    m += 1;
                }
                maxLCS = Math.max(maxLCS, m - n);
            }
        }
        return maxLCS;
    }





    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longest = 0;
        for (int i = 0; i < nums.length;i++) {
            int down = nums[i] - 1;
            while(set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = nums[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }

            longest = Math.max(longest,up - down - 1);
        }
        return longest;
    }


    public int longestConsecutive_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int rst = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
                int sum = left + right + 1;
                map.put(num, sum);
                rst = Math.max(rst,sum);
                map.put(num - left, sum);
                map.put(num + right,sum);
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequence test = new LongestConsecutiveSequence();
        System.out.println(test.longestConsecutive_2(nums));
        System.out.println(test.longestConsecutiveBest(nums));
    }
}
