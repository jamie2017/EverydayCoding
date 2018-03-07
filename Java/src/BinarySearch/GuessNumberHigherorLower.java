package BinarySearch;

/**
 * Created by JMYE on 9/26/16.
 */
public class GuessNumberHigherorLower {
    int guess(int num) {
        return num;
    }
    public int guessNumber(int n) {
        int low = 1, high = n;
        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (guess(low) == 0) return low;
        return high;
    }
}
