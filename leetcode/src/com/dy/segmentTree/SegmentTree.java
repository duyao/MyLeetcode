package com.dy.segmentTree;

public class SegmentTree {
	int[] array;
	int n;

	SegmentTree(int[] nums) {
		n = nums.length;
		array = new int[nums.length * 2];
		for (int i = 0; i < nums.length; i++) {
			array[n + i] = nums[i]; 
		}
		for (int i = n - 1; i >= 0; i--) {
			//array[i] = array[2*i] + array[2*i+1]
			array[i] = array[i << 1] + array[i << 1 | 1];
		}
	}

	void modify(int p, int value) { // set value at position p
		for (array[p += n] = value; p > 1; p >>= 1) {
			//array[p/2] = array[p] + array[p];
			array[p >> 1] = array[p] + array[p ^ 1];
		}
	}

	int query(int l, int r) { // sum on interval [l, r)
		int res = 0;
		for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
			//(l&1) ==> l%1 ==> odd
			if ((l & 1) == 1) {
				res += array[l++];
			}
			if ((r & 1) == 1){
				
				res += array[--r];
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[4];
		for(int i = 0; i < 4; i++){
			nums[i] = i;
		}
		SegmentTree tree = new SegmentTree(nums);
		int x = tree.query(0, 2);
		System.out.println(x);
		tree.modify(1, 2);
		x = tree.query(0, 2);
		System.out.println(x);
	}

}
