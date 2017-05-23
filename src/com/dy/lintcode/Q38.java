package com.dy.lintcode;

/**
 * Created by amy on 2017/5/23.
 */
public class Q38 {
    public static int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int i = 0;
        int j = matrix[0].length - 1;
        int cnt = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                cnt++;
            }

        }
        return cnt;
    }

    public static void main(String[] args) {

        int[][] nums = new int[][]{{3, 4}};
        System.out.println(searchMatrix(nums, 3));

    }
}
