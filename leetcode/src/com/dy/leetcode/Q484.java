package com.dy.leetcode;

import java.util.*;

/**
 * Created by amy on 2017/3/13.
 */
public class Q484 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int a[] = {4, 3, 2, 7, 8, 2, 3, 1};
        Q484 q = new Q484();
        q.findDisappearedNumbers(a);


    }
}
