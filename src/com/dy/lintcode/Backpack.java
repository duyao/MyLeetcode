package com.dy.lintcode;

import java.util.Arrays;

/**
 * Created by amy on 2017/4/21.
 */
class t {
    public static int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 1) {
            return a % b;
        } else if (n == 0) {
            return 1 % b;
        } else if (n < 0) {
            return 1 / fastPower(a, b, -n);
        }

        long  res = 1;
        long aa = a % b;
        while (n > 0) {

            if ((n & 1) == 1) {
                res = (res * aa) % b;
            }
            aa = aa * aa % b;
            n /= 2;
        }
        return (int)res;


    }

    public static void main(String[] args) {
        int x = fastPower(2, 2147483647, 2147483647);
//        int x = fastPower(2, 3, 6);
        System.out.println(x);
    }
}

public class Backpack {
    //    http://www.lintcode.com/zh-cn/problem/backpack/
    public static int backPack(int m, int[] A) {
        int[][] dp = new int[A.length + 1][m + 1];
//        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(A[i - 1] + dp[i - 1][j - A[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[A.length][m];
    }

    public static int backPackII(int m, int[] A, int V[]) {
        //A体积，V价值
        // 必须将第0行第0列空出来，因为这是初始状态
        int[][] dp = new int[A.length + 1][m + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(V[i - 1] + dp[i - 1][j - A[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[A.length][m];
    }


    public static int backPackII1(int m, int[] A, int V[]) {
        //A体积，V价值
        // write your code here
        int[] dp = new int[m + 1];

        //空间优化，使用一维空间，必须倒着遍历，因为上一轮的状态记录在前面
        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j >= 0; j--) {
                if (j >= A[i - 1]) {
                    dp[j] = Math.max(V[i - 1] + dp[j - A[i - 1]], dp[j]);
                } else {
                    dp[j] = dp[j];
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[m];
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 5, 7};
        int[] V = new int[]{1, 5, 2, 4};
//        int x = backPackII(10, A, V);
//        int xx = backPackII1(10, A, V);
//        System.out.println(xx);
        int x = backPack(12, A);
        System.out.println(x);

    }
}
