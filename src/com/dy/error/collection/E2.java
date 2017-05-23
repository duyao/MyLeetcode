package com.dy.error.collection;

public class E2 {
	public static void main(String[] args) {
		int x= 0;
		int y=0;
		int k =0;
		for(int z=0;z<5;z++){
			//前面的条件不符合，就不继续进行
			//z=0,x=1,y,k不变
			if((++x)>2&&(++y>2)&&(k++>2)){
				x++;
				++y;
				k++;
			}
		}
		System.out.println(x+" "+y+" "+k);
	}
	
	

}
