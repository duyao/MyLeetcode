package com.dy.leetcode;

/**
 * Created by amy on 16-11-6.
 */
public class Q416 {
    //这是说的是subset，指的是中间可以缺少某些元素。可以非连续
    //subarray中间不能缺少元素，必须是连续的
    //subsquence是不连续，但是下标必须是递增的
    //http://stackoverflow.com/questions/26568560/difference-between-subarray-subset-subsequence
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        //dp[i][j]表示的是从nums[0]到nums[j]的和是不是可以为i，也就是子集从0到j和是不是为i
        boolean dp[][] = new boolean[sum + 1][nums.length];
        //和为0，都可以做到
        for (int i = 0; i < nums.length; i++) {
            dp[0][i] = true;
        }
        //初始化第一列
        for (int i = 0; i < sum + 1; i++) {
            if (nums[0] == i) {

                dp[i][0] = true;
            }
        }

        for (int i = 1; i < sum + 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i][j] = dp[i][j - 1] || dp[i - nums[j]][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }

            }
        }

        //   for(int i = 0; i < sum+1; i++){
        //         for(int j = 0; j < nums.length; j++){
        //             System.out.print(dp[i][j]+" ");

        //         }
        //         System.out.println("");
        //     }

        return dp[sum][nums.length - 1];

    }
}
