package com.dy.leetcode;

public class Q42 {
	public int trap(int[] height) {
		int i = 0;
		int j = height.length - 1;
		//��¼��ǰ���߶�
		int curh = 0;
		//��¼ÿ��ֵ�ĸ߶�
		int[] res = new int[height.length];
		while (i <= j) {
			if (height[i] > height[j]) {
				// curh = Math.max(curh, height[i]);
				curh = Math.max(curh, height[j]);
				res[j] = curh;
				j--;
			} else if (height[i] < height[j]) {
				curh = Math.max(curh, height[i]);
				res[i] = curh;
				i++;
			} else {
				curh = Math.max(curh, height[i]);
				res[i] = curh;
				res[j] = curh;
				i++;
				j--;
			}

		}
		int cnt = 0;
		for (int k = 0; k < height.length; k++) {
			cnt += (res[k] - height[k]);
		}
		return cnt;

	}

}
