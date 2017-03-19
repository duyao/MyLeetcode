package com.dy.leetcode;

/**
 * Created by think on 2017-02-02.
 */
public class Q59 {

    public int[][] generateMatrix(int n) {
        int [][] ans = new int[n][n];
        int cnt = 0;
        int a = 0;
        int b = n-1;
        while(a <= b){
            for(int i = a; i < b ; i++){
                ans[a][i] = ++cnt;
            }
            for(int i = a; i < b; i++){
                ans[i][b] = ++cnt;
            }
            for(int i = b; i > a ; i--){
                ans[b][i] = ++cnt;
            }
            for(int i = b; i > a ; i--){
                ans[i][a] = ++cnt;
            }
            if(a == b){
                ans[a][a] = ++cnt;
            }
            a++;
            b--;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d",ans[i][j]);
            }
            System.out.println();
        }
//        //打印数组
//        System.out.println(Arrays.toString(ans));
//        //打印二维数组
//        System.out.println(Arrays.deepToString(ans));

        return ans;


    }

    public static void main(String[] args) {
        Q59 q = new Q59();
        int ans [][] = q.generateMatrix(3);


    }
}
