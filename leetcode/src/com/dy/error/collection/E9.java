package com.dy.error.collection;

public class E9 {
	
	public static void main(String[] args) {
//		Integer i1 = 59;
//		int i2 = 59;
//		Integer i3 = Integer.valueOf(59);
//		Integer i4 = new Integer(59);
		Integer i1 = 111111;
		int i2 = 111111;
		Integer i3 = Integer.valueOf(111111);
		Integer i4 = new Integer(111111);
		//��Ϊ59ʱ��1-3����true
		//��Ϊjvm����С��1�ֽڵ����µ�����������ؽ��ڴ棬������new Integer()��ʾ�����½�����
		//���1-3����ָ��ͬһ������,���12�棬4��
		//��3�Ƕ���int���бȽ�ֵ�Ĵ�С
		//��Ϊ111111ʱ��13true��24false
		//i3��valueof�����ж������Ƕ�С��1�ֽ�(127)����С�ڲ������¶��󣬴���127������¶���
		System.out.println(i1 == i2);
		System.out.println(i1 == i3);
		//24��23��ʱ����ȣ���Ϊ2��int3��Integer����Ϊһ���ǻ������ͣ�һ���Ƿ�װ��
		System.out.println(i2 == i4);
		System.out.println(i3 == i4);
		
		System.out.println(i2 == i3);
		//���ۺ�ʱ14����1��4�ǲ�ͬ�Ķ�����Ϊ4��new����Ȼ���Ƕ���integer
		System.out.println(i1 == i4);

	}

}
