package com.dy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q347_1 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer x = map.get(nums[i]);
            if (x == null) {
                x = 0;
            }
            map.put(nums[i], x + 1);
            max = Math.max(max, map.get(nums[i]));

        }

        ArrayList<Integer>[] arr = new ArrayList[max + 1];
        for (Integer key : map.keySet()
                ) {
            if (arr[map.get(key)] == null) {
                arr[map.get(key)] = new ArrayList<>();
            }
            arr[map.get(key)].add(key);
        }


        for (int i = max; i >= 0; i--) {
            if (k == 0) {
                break;
            }
            //这里要进行判断，因为有频率没有值
            //判定的条件是有list而不是list的size为0
//            if (arr[i].size() != 0) {
            if (arr[i] != null) {
                for (int j = 0; j < arr[i].size(); j++) {
                    if (k == 0) {
                        break;
                    }
                    res.add(arr[i].get(j));
                    k--;

                }
            }


        }
        return res;


    }


    public static void main(String[] args) {
        Q347_1 q = new Q347_1();
        int[] nums = {5, 3, 1, 1, 1, 3, 73, 1};
        int k = 2;
        List<Integer> list = q.topKFrequent(nums, k);
        System.out.println("x= " + list);
    }
}
