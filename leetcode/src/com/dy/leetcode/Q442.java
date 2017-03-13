package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amy on 2017/3/13.
 */
public class Q442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
                System.out.println("pos:"+(i+1)+"-val-"+val+"->"+-nums[val]);
            }else{
                System.out.println("NO:pos:"+i+"->"+nums[val]);
                ret.add(i+1);
            }
        }


        return ret;
    }

    public static void main(String[] args) {
        int a[] = {4, 3, 2, 7, 8, 2, 3, 1};
        Q442 q = new Q442();
        q.findDuplicates(a);


    }
}
