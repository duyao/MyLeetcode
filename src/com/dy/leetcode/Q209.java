package com.dy.leetcode;

/**
 * Created by dy on 2016/9/28.
 */
public class Q209 {
	public int minSubArrayLen(int s, int[] nums) {
		int len = 0;
		int i = 0, j = 0;
		int sum = 0;
		int res = Integer.MAX_VALUE;
		//在和到达sum时，怎么退出？此时i还不到最后，j已经到了最后
		while (i != nums.length - 1 || sum < s) {
			if (j < nums.length && sum <= s) {
				len++;
				sum += nums[j++];
			} else if (sum > s) {
				sum -= nums[i++];
				len--;
			}
			res = sum >= s ? Math.min(len, res) : res;
			if (sum <= s && j == nums.length) {
				break;
			}
		}
		res = res == Integer.MAX_VALUE ? 0 : res;
		return res;
	}

	public static void main(String[] args) {
		Q209 q = new Q209();
		int[] nums = new int[]{2, 3, 1, 2, 4, 3};
		int s = 7;
		int k = q.minSubArrayLen(s, nums);
		System.out.println(k);

	}
}
