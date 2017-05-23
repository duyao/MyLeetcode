package com.dy.leetcode;

public class Q334 {
    public static boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int x :
                nums) {
            if (x < a) {
                a = x;
            } else if (x < b) {
                b = x;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int a[] = {3, 5, 1, 6};
        System.out.println(increasingTriplet(a));
    }

}
