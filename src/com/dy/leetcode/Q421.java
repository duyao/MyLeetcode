package com.dy.leetcode;

/**
 * Created by amy on 16-10-28.
 */
public class Q421 {
    //把每个数字的每一个位上的二进制数值存在tire中,然后对每一位进行比较,看能否产生最高位的1
    public int findMaximumXOR(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }
        // Init Trie.
        // 将数字的二进制表示保存在tire中
        // 第0层表示树根,第1层表示最高位,第2层表示次高位
        // 有值则该位置不为空,否则为null
        Object[] root = {null, null};
        for(int num: nums) {
            Object[] curNode = root;
            for(int i = 31; i >= 0; i --) {
                // num >>> i先将数字无符号右移i位,再与1得到0或者1表示i位置上的值
                // 比如 8>>>3=0001b,0001b&1 = 1; 8>>>2=0010b,0010b&1=0
                // 因此curBit表示i位置上二进制的值
                int curBit = (num >>> i) & 1;
                //插入到tire树中,如果该位置为null则初始化
                if(curNode[curBit] == null) {
                    curNode[curBit] = new Object[]{null, null};
                }
                //将父子节点建立联系
                curNode = (Object[]) curNode[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        //求出最大值,原理是a^b=max,那么max^a=b,max^b=a
        for(int num: nums) {
            Object[] curNode = root;
            int curSum = 0;

            for(int i = 31; i >= 0; i --) {
                // 获得i位置的二进制值
                int curBit = (num >>> i) & 1;
                // 这里1相当于max,curBit相当于a,那么curBit ^ 1为b,因此要判断b是否存在
                if(curNode[curBit ^ 1] != null) {
                    //b存在说明可以产生最大值1<<i=2的i次方,并且累加cursum
                    curSum += (1 << i);
                    //更新cur
                    curNode = (Object[]) curNode[curBit ^ 1];
                }else {
                    //更新cur
                    curNode = (Object[]) curNode[curBit];
                }
            }
            // 遍历结束一个数字,可以得到一个最大值
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
