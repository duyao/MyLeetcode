package com.dy.error.collection;

public class E4 {
		public int add(int a, int b){
			try {
				return a+b;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				//��ִ��finally�������ݣ�Ȼ����ִ�иոձ���Ľ��
				//��finally����return��䣬��ֱ��ִ��finally��������ִ��
//				return -1;
				System.out.println("finally����");
			}
			return 0;
		}
	public static void main(String[] args) {
		E4 e =new E4();
		System.out.println("����"+e.add(9, 34));
		
	}

}
