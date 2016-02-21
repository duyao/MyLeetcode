package com.dy.error.collection;

public class E4 {
		public int add(int a, int b){
			try {
				return a+b;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				//先执行finally语句的内容，然后再执行刚刚保存的结果
				//若finally中有return语句，则直接执行finally，其他不执行
//				return -1;
				System.out.println("finally语句块");
			}
			return 0;
		}
	public static void main(String[] args) {
		E4 e =new E4();
		System.out.println("和是"+e.add(9, 34));
		
	}

}
