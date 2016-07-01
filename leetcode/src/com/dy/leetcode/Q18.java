package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Q18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i = 0; i <= n-4; i++){
        	//提高效率
        	//本轮最大的数，仍小于target，因此需要增加i
        	if(nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target) continue;
        	//本轮最小的数，都大于target，无结果
        	if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target) break;
            for(int j = i + 1; j <= n-3; j++){
            	//提高效率
            	//本轮最大的数，仍小于target，因此需要增加i
            	if(nums[i] + + nums[j] + nums[n-1] + nums[n-2]  < target) continue;
            	//本轮最小的数，都大于target，无结果
            	if(nums[i] + + nums[j] + nums[j+1] + nums[j+2] > target) break;
                int s = j + 1;
                int e = n - 1;
                while(s < e){
                    int sum = nums[i] + nums[j] + nums[s] + nums[e];
                    if(sum < target){
                        s++;
                    }else if(sum > target){
                        e--;
                    }else{
                        List<Integer> tmp = Arrays.asList(nums[i] , nums[j] ,nums[s] ,nums[e]);
                        Collections.sort(tmp);
                        set.add(tmp);
                        s++;
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
        
    }
	public static void main(String[] args) {
//		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
//		List<Integer> l1 = new ArrayList();
//		l1.add(1);
//		l1.add(2);
//		List<Integer> l2 = new ArrayList();
//		l2.add(1);
//		l2.add(2);
//		set.add(l1);
//		set.add(l2);
//		System.out.println(l1.hashCode());
//		System.out.println(l2.hashCode());
//		System.out.println(set.size());
		Q18 q = new Q18();
		int[] nums = {0,0,0,0};
		List<List<Integer>> list = q.fourSum(nums, 0);
		for (List<Integer> list2 : list) {
			for (Integer integer : list2) {
				System.out.print(integer+",");
			}
			System.out.println();
		}
	}

}
