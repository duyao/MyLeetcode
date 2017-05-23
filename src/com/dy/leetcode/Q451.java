package com.dy.leetcode;

import java.util.*;
import java.util.BitSet;

/**
 * Created by amy on 2017/3/20.
 */
public class Q451 {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int maxf = 0;
        //首先算出每个值出现的频率
        int fren[] = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            fren[cur]++;
            maxf = Math.max(maxf, fren[cur]);
        }
        //然后新建一个数组把频率作为下标，值就是字母的list，因为可能多个值出现同样的次数
        ArrayList<Character>[] list = new ArrayList[maxf + 1];
        for (int i = 0; i < 128; i++) {
            if (fren[i] != 0) {
                if (list[fren[i]] == null) {
                    list[fren[i]] = new ArrayList<>();
                }
                list[fren[i]].add((char) i);

            }
        }


        //遍历新建的数组
        StringBuffer sb = new StringBuffer();
        for (int i = maxf; i >= 0; i--) {
            if (list[i] != null) {
                for (int k = 0; k < list[i].size(); k++) {
                    for (int j = 0; j < i; j++) {
                        sb.append(list[i].get(k));
                    }
                }


            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Q451 q = new Q451();
        System.out.println(q.frequencySort("cccaaa"));
    }
}
