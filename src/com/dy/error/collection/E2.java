package com.dy.error.collection;

public class E2 {
	public static void main(String[] args) {
		int x= 0;
		int y=0;
		int k =0;
		for(int z=0;z<5;z++){
			//ǰ������������ϣ��Ͳ���������
			//z=0,x=1,y,k����
			if((++x)>2&&(++y>2)&&(k++>2)){
				x++;
				++y;
				k++;
			}
		}
		System.out.println(x+" "+y+" "+k);
	}
	
	

}
