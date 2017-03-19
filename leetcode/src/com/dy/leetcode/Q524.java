package com.dy.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Created by think on 2017-02-26.
 */
public class Q524 {
    public String findLongestWord(String s, List<String> d) {
        d.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.length() - o1.length() != 0) {
                    return o2.length() - o1.length();
                }else{
                    return o1.compareTo(o2);
                }
            }
        });

        for (String ss : d
             ) {
            int i  = 0;
            int j = 0;
            boolean b = false;
            while(i < s.length() && j < ss.length()){
                if(s.charAt(i) == ss.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            if(j == ss.length()){
                return  ss;
            }
        }

        return "";

    }

    public static void main(String[] args) {
        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea","paple");
        Q524 q = new Q524();
        q.findLongestWord("abpcplea", d);
    }
}
