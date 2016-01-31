package com.dy.leetcode;

//https://en.wikipedia.org/wiki/Digital_root
public class Q258 {
	public int addDigits(int num) {
		return (int) (num - 9*Math.ceil((num-1)/9));
	}

}
