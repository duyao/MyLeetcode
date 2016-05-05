package com.dy.leetcode;

public class Q334 {
	public String reverseString(String s) {
        if(s == null ){
            return s;
        }
        int i = 0;
        int j = s.length()-1;
        char[] c = s.toCharArray();
        while(i < j){
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j--;
        }
        return new String(c);
    }

}
