package com.dy.leetcode;

/**
 * Created by amy on 16-11-6.
 */
public class Q416 {
    //����˵����subset��ָ�����м����ȱ��ĳЩԪ�ء����Է�����
    //subarray�м䲻��ȱ��Ԫ�أ�������������
    //subsquence�ǲ������������±�����ǵ�����
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
        //dp[i][j]��ʾ���Ǵ�nums[0]��nums[j]�ĺ��ǲ��ǿ���Ϊi��Ҳ�����Ӽ���0��j���ǲ���Ϊi
        boolean dp[][] = new boolean[sum + 1][nums.length];
        //��Ϊ0������������
        for (int i = 0; i < nums.length; i++) {
            dp[0][i] = true;
        }
        //��ʼ����һ��
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
