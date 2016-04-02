package com.dy.leetcode;

public class Q91 {

	public int numDecodings(String s) {
		int n = s.length();
		if (n == 0)
			return 0;

		int[] memo = new int[n + 1];
		memo[n] = 1;
		memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--)
			if (s.charAt(i) == '0')
				continue;
			else
				memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1]
						+ memo[i + 2]
						: memo[i + 1];

		return memo[0];
	}

	// public int f(String str, int s, int e){
	// if(s == e){
	// return 0;
	// }else if(s == e-1){
	// int tmp = Integer.valueOf(str.substring(s,e));
	// return tmp > 0 && tmp < 27 ? 1 : 0;
	// }else{
	// int tmp = Integer.valueOf(str.substring(s,e));
	// tmp = tmp > 0 && tmp < 27 ? 1 : 0;
	// for(int i = 1; i < e - s;i++){
	// int x = Math.max(f(str, s, s+i), f(str, s+i, e));
	// System.out.println("tmp="+tmp);
	// tmp += x;
	// System.out.println(x +"," +str.substring(s, s+i)+","+str.substring(s+i,
	// e));
	// System.out.println("tmp+x"+"("+x+")"+"="+tmp);
	// }
	// return tmp;
	// }
	// }

	public static void main(String[] args) {
		String s = "1314";
		Q91 q = new Q91();
		int x = q.numDecodings(s);
		System.out.println(x);
	}

}
