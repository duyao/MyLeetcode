package com.dy.leetcode;

public class Q88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = nums1.length - 1, j = m - 1;
		for(; j >= 0; i--,j--){
			nums1[i] = nums1[j];
		}
		//j在0的位置，i在nums1中第一个数的位置
		j++;i++;
		int cnt = 0;
		while(i < nums1.length && j < n){
			if(nums1[i] <= nums2[j]){
				nums1[cnt++] = nums1[i];
				i++;
			}else{
				nums1[cnt++] = nums2[j];
				j++;
			}
		}
		while(j < n){
			nums1[cnt++] = nums2[j++];
		}
		while(i < nums1.length){
			nums1[cnt++] = nums1[i++];
		}
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[10];
		int[] nums2 = {3, 10};
		for(int i = 0; i < 5; i++){
			nums1[i] = 2 * i;
		}
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i] + ",");
		}
		System.out.println();
		Q88 q = new Q88();
		q.merge(nums1, 5, nums2, 2);
		for (int i = 0; i < 7; i++) {
			System.out.print(nums1[i] + ",");
		}
		System.out.println();
		
	}
	

}
