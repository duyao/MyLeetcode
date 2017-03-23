package com.dy.nowcoder.cc150;

/**
 * Created by amy on 2017/3/19.
 */
public class Q1_1 {
    public static void main(String[] args) {
        Q1_1 q = new Q1_1();
        q.isUniqueChars("baba");

    }

    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            int x = 1 << val;
            int y = x& checker;
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }
}
