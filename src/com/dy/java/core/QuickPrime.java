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
			//1.ÿ�����ֶ��ᾭ����ѭ��
			//a.������������ͱ��������������������k=p1*p2����p1,p2���ǲ���ͬ��������һ�������ظ�ɸѡ
			//b.����Ǻ�������ֻɹ�������ֺ���С�����ĳ˻�������ɸѡ�Ų����ظ���
			//��Ϊһ�����������������ĳ˻�����Ϊɸѡ���̲��ظ������ֻ�ᱻ��С��������һ���ֳ˻�ʱѡס
			for(int j = 0; j < cnt && prime[j] * i < N; j++){
				isNot[i * prime[j]] = true;
//				System.out.println("i * prime[j] = "+i+"*"+prime[j]+" = "+i * prime[j]);
				//2.�ú����������ı������˳�ɸѡ
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
