package com.dy.leetcode;

import java.util.*;

/**
 * Created by amy on 2017/3/20.
 */
public class Q3_2 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, cur = 0;
        int maxl = 0;
        while (cur < s.length()) {
            if (map.containsKey(s.charAt(cur))) {
                //注意这里不能单纯找后一个值，而是要比较当前值与回退值哪个大
                //比如abba
                start = Math.max(start, map.get(s.charAt(cur)) + 1);
            }

            //这里每次都要更新位置
            map.put(s.charAt(cur), cur);
            //全部都是闭区间
            maxl = Math.max(maxl, cur - start + 1);
            cur++;

        }
        System.out.println(maxl);
        return maxl;


    }

    public static void main(String[] args) {

        Q3_2 q = new Q3_2();
        String s = "abba";
        q.lengthOfLongestSubstring(s);
    }
}
