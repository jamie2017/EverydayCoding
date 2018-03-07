package TwoPointer;

import java.util.Arrays;

/**
 * Created by JMYE on 9/4/16.
 */
public class TriangleCount {
    public int triangleCount(int S[]) { // two sum II variation
        int ans = 0;
        Arrays.sort(S);
        int left, right;
        for (int i = 0; i < S.length; i++) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    ans += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
