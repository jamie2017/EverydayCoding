package DP;

/**
 * Created by JMYE on 9/29/16.
 */
/**
 * Date 07/31/2014
 * @author tusroy
 *
 * Write a program to find maximum sum rectangle in give 2D matrix.
 * Assume there is at least one positive number in the 2D matrix.
 *
 * Solution:
 * Keep temp array with size as number of rows. Start left and right from 0
 * and keep adding values for each row and maintain them in this temp array.
 * Run Kadane's algorithm to find max sum subarray in temp. Now increment right by
 * 1. When right reaches last column reset right to 1 and left to 1.
 *
 * Space complexity of this algorithm is O(row)
 * Time complexity of this algorithm is O(row*col*col)
 *
 * References
 * http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
 */
public class SubRectangularMatrixWithMaximumSum {
// time O(col * col * row) , space O(row)
    class Result{
        int maxSum;
        int leftBound;
        int rightBound;
        int upBound;
        int lowBound;
    public Result(){
    }

    }

    public int maxSumSubmatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int temp[] = new int[rows];
        Result result = new Result();
        for(int left = 0; left < cols ; left++){
            for(int i = 0; i < rows; i++){
                temp[i] = 0;
            }
            for(int right = left; right < cols; right++){
                for(int i=0; i < rows; i++){
                    temp[i] += matrix[i][right];
                }
                KadaneResult kadaneResult = kadane(temp);
                if(kadaneResult.maxSum > result.maxSum){
                    result.maxSum = kadaneResult.maxSum;
                    result.leftBound = left;
                    result.rightBound = right;
                    result.upBound = kadaneResult.start;
                    result.lowBound = kadaneResult.end;
                }
            }
        }
        return result.maxSum;
    }

    class KadaneResult{
        int maxSum;
        int start;
        int end;
        public KadaneResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }

    private KadaneResult kadane(int arr[]){
        int max = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int currentStart = 0;
        int maxSoFar = 0;
        for(int i=0; i < arr.length; i++){
            maxSoFar += arr[i];

            if(maxSoFar < 0){
                maxSoFar = 0;
                currentStart = i+1;
            }
            if(max < maxSoFar){
                maxStart = currentStart;
                maxEnd = i;
                max = maxSoFar;
            }

        }
        return new KadaneResult(max, maxStart, maxEnd);
    }


    public static void main(String args[]){
        int input[][] = {
                { 1,0,1},
                {0,-2,3}};
        SubRectangularMatrixWithMaximumSum saw = new SubRectangularMatrixWithMaximumSum();
        System.out.println(saw.maxSumSubmatrix(input));
    }
}
