package com.dy.error.collection;

public class E9 {
	
	
	//װ�����  �Զ���������������ת��Ϊ��װ�����ͣ��������  �Զ�����װ������ת��Ϊ�����������͡�
	//��Ҫ�ǿ��Ⱥ���ߵĶ��������
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
		
		
		//Integer��Short��Byte��Character��Long�⼸�����valueOf������ʵ�������Ƶġ�
		//Double��Float��valueOf������ʵ�������Ƶġ�
		Double d1 = 34.0;
		Double d2 = 34.0;
		System.out.println("d1 == d2  ->  " + (d1 == d2));
		
		
		//�� "=="��������������������� ��װ�����͵����ã����ǱȽ�ָ����Ƿ���ͬһ������
		//�����������һ���������Ǳ��ʽ���������������㣩��Ƚϵ�����ֵ�����ᴥ���Զ�����Ĺ��̣�
		Long ll = 3l;
		int a = 1;
		int b = 2;
//		long b = 2;
		System.out.println(ll == (a + b));
		//���ڰ�װ�����ͣ�equals�����������������ת��,�Ƚ��Ƿ�������ͬ
		System.out.println(ll.equals(a + b));
		

	}

}
