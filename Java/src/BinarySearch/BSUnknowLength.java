package BinarySearch;

/**
 * Created by JMYE on 6/19/17.
 */
public class BSUnknowLength {

    public int getIndex(int[] arr, int num) {
        int idx = 0, exp = 0;
        while (true) {
            try {
                if (arr[idx] == num) {
                    return idx;
                } else if (arr[idx] < num) {
                    idx = (int)Math.pow(2,exp);
                    exp ++;
                } else {
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        int left = (idx / 2) + 1;
        int right = idx - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            try {
                if (arr[mid] == num) {
                    return mid;
                } else if (arr[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } catch (IndexOutOfBoundsException e) {
                right = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        BSUnknowLength test = new BSUnknowLength();
        int arr[] = {1,2,3,4,5,6,7,9};
        System.out.println(test.getIndex(arr,1));
        System.out.println(test.getIndex(arr,2));
        System.out.println(test.getIndex(arr,5));
        System.out.println(test.getIndex(arr,8));
        System.out.println(test.getIndex(arr,10));
        System.out.println(test.getIndex(arr,9));

    }

}
