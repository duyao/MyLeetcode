package com.dy.leetcode;


import java.util.*;

/**
 * Created by amy on 2017/3/7.
 */
public class Q139 {

    public static boolean wordBreak(String s, List<String> wordDict) {


        Collections.sort(wordDict);
        if (s.length() == 1) {
            int aa = Collections.binarySearch(wordDict, s);

            return aa >= 0 ? true : false;

        }
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j > 0; j--) {
                int aa = Collections.binarySearch(wordDict, s.substring(j, i + 1));
                if (dp[j - 1] && aa > -1) {
                    dp[i] = true;
                    break;
                }

            }

        }

        for (int i = 1; i < dp.length; i++) {
            if (dp[i] && dp[i - 1]) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("ca");
        list.add("bc");
        list.add("e");
        System.out.println(wordBreak("bccae", list));

    }

}
