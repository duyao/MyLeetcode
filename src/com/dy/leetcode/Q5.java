package com.dy.leetcode;

/**
 * Created by amy on 2017/3/24.
 */
public class Q5 {
    public static  String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        if (s.length() == 1) return s;
        int min_start = 0, max_len = 1;
        for (int i = 0; i < s.length(); ) {
            if (s.length() - i <= max_len / 2) break;
            int j = i, k = i;
            while (k < s.length() - 1 && s.charAt(k + 1) == s.charAt(k)) ++k; // Skip duplicate characters.
            i = k + 1;
            while (k < s.length() - 1 && j > 0 && s.charAt(k + 1) == s.charAt(j - 1)) {
                ++k;
                --j;
            } // Expand.
            int new_len = k - j + 1;
            if (new_len > max_len) {
                min_start = j;
                max_len = new_len;
            }
        }
        return s.substring(min_start, max_len);
    }

    public static void main(String[] args) {
        String s = "baaabcd";
        longestPalindrome(s);

    }
}
