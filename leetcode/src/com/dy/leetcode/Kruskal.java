package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by amy on 2017/2/21.
 */
public class Kruskal {
    //点数
    int numv = 100;

    ArrayList<Edge> edges = new ArrayList<>();
    int father[] = new int[numv];
    //并查集
    public int findfather(int x){
        int a = x;
        while(x != father[x]){
            x = father[x];
        }
        //路径压缩,放置树太高，影响查找效率
        while(a != father[a]){
            int z = a;
            a = father[a];
            father[z] = a;
        }
        return x;
    }

    public int Kru(int v, int e){

        //最小生成树的权值
        int ans = 0;
        //生成树的边数
        int vis = 0;
        //初始化并查集
        for (int i = 0; i < v; i++) {
            father[i] = i;
        }

        //对边的权值进行排序
        Collections.sort(edges);

        for(int i = 0; i < e; i++){

            int uu = edges.get(i).u;
            int vv = edges.get(i).v;

            //查看vv和uu是不是在同一个集合中
            int fau = findfather(uu);
            int fav = findfather(vv);
            if(fau != fav){
                //加入到集合中去
                father[fau] = fav;
                //生成树权值增加
                ans += edges.get(i).cost;
                //生成树边数增加
                vis++;
                //生成树的边数为n-1，结束生成树查找
                if(vis == v - 1){
                    break;
                }
            }



        }

        if(vis == v - 1){
            //返回生成树权值
            return ans;
        }else{
            //不能生成生成树
            return -1;
        }
    }



}
class Edge implements Comparable<Edge>{
    int u,v;
    int cost;


    @Override
    public int compareTo(Edge o) {
        return Integer.compare(o.cost, this.cost);
    }
}
