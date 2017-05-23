package com.dy.leetcode;

/**
 * Created by amy on 16-10-28.
 */
public class Q421 {
    //��ÿ�����ֵ�ÿһ��λ�ϵĶ�������ֵ����tire��,Ȼ���ÿһλ���бȽ�,���ܷ�������λ��1
    public int findMaximumXOR(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }
        // Init Trie.
        // �����ֵĶ����Ʊ�ʾ������tire��
        // ��0���ʾ����,��1���ʾ���λ,��2���ʾ�θ�λ
        // ��ֵ���λ�ò�Ϊ��,����Ϊnull
        Object[] root = {null, null};
        for(int num: nums) {
            Object[] curNode = root;
            for(int i = 31; i >= 0; i --) {
                // num >>> i�Ƚ������޷�������iλ,����1�õ�0����1��ʾiλ���ϵ�ֵ
                // ���� 8>>>3=0001b,0001b&1 = 1; 8>>>2=0010b,0010b&1=0
                // ���curBit��ʾiλ���϶����Ƶ�ֵ
                int curBit = (num >>> i) & 1;
                //���뵽tire����,�����λ��Ϊnull���ʼ��
                if(curNode[curBit] == null) {
                    curNode[curBit] = new Object[]{null, null};
                }
                //�����ӽڵ㽨����ϵ
                curNode = (Object[]) curNode[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        //������ֵ,ԭ����a^b=max,��ômax^a=b,max^b=a
        for(int num: nums) {
            Object[] curNode = root;
            int curSum = 0;

            for(int i = 31; i >= 0; i --) {
                // ���iλ�õĶ�����ֵ
                int curBit = (num >>> i) & 1;
                // ����1�൱��max,curBit�൱��a,��ôcurBit ^ 1Ϊb,���Ҫ�ж�b�Ƿ����
                if(curNode[curBit ^ 1] != null) {
                    //b����˵�����Բ������ֵ1<<i=2��i�η�,�����ۼ�cursum
                    curSum += (1 << i);
                    //����cur
                    curNode = (Object[]) curNode[curBit ^ 1];
                }else {
                    //����cur
                    curNode = (Object[]) curNode[curBit];
                }
            }
            // ��������һ������,���Եõ�һ�����ֵ
            max = Math.max(curSum, max);
        }
        return max;

    }

    public static void main(String[] args) {

        Q421 q = new Q421();
        int z = q.findMaximumXOR(
                new int []{3,5,6,8}
        );

        System.out.println(z);
    }
}
