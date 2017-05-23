package com.dy.java.core;

public class QuickPrime {
	public static void main(String[] args) {
		final int N = 100000;
		boolean[] isNot = new boolean[N];
		int[] prime = new int[N];
		int cnt = 0;
		for(int i = 2; i < N; i++){
			if(!isNot[i]){
				prime[cnt++] = i;
			}
			//1.每个数字都会经过这循环
			//a.如果是素数，就标记素数的素数倍数，即k=p1*p2，而p1,p2都是不相同的素数，一定不会重复筛选
			//b.如果是合数，就只晒出该数字和最小素数的乘积，这样筛选才不会重复。
			//因为一个合数是若干素数的乘积，因为筛选过程不重复，因此只会被最小素数和另一数字乘积时选住
			for(int j = 0; j < cnt && prime[j] * i < N; j++){
				isNot[i * prime[j]] = true;
//				System.out.println("i * prime[j] = "+i+"*"+prime[j]+" = "+i * prime[j]);
				//2.该合数是素数的倍数就退出筛选
				if(i%prime[j] == 0){
					break;
				}
			}
			
		}
		for (int i = 0; i < cnt; i++) {
//			System.out.println(prime[i]);
		}
	}
	

}
