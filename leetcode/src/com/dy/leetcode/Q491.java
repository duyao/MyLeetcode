package com.dy.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by amy on 2017/3/5.
 */
public class Q491 {


    public List<List<Integer>> findSubsequences(int[] nums) {

        HashSet<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(res);
        }


        res.add(new ArrayList<>());
        for (int j = 0; j < nums.length; j++) {
            HashSet<List<Integer>> tmpres = new HashSet<>(res);
            Iterator<List<Integer>> i = res.iterator();
            while (i.hasNext()) {
                List<Integer> cur = i.next();

                if (cur.size() == 0 || cur.size() > 0 && nums[j] >= cur.get(cur.size() - 1)) {
                    List<Integer> tmp = new ArrayList<>(cur);
                    tmp.add(cur.size(), nums[j]);
                    tmpres.add(tmp);
                }

            }

            res = tmpres;
        }

        System.out.println(res);
        List<List<Integer>> list = new ArrayList<>();
        Iterator<List<Integer>> i = res.iterator();
        while (i.hasNext()) {
            List<Integer> cur = i.next();
            if (cur.size() > 1) {
                list.add(cur);
            }

        }


        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        Q491 q = new Q491();
        int[] nums = {4, 6, 7, 7};
        q.findSubsequences(nums);


    }
}
