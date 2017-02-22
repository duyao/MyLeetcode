package com.dy.leetcode;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;

/**
 * Created by amy on 2017/2/20.
 */
public class Q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //一个点可能有多个前驱
        int[] indegree = new int[numCourses];
        List<List<Integer>> g = new ArrayList<>();
        boolean[] vis = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            indegree[i] = 0;
            vis[i] = false;
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            g.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        ArrayList<Integer> start = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                start.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < start.size(); i++) {

            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(start.get(i));
            int cur = -1;
            while (!queue.isEmpty()) {
                cur = queue.remove();
                res.add(cur);
                vis[cur] = true;
                for (int j = 0; j < g.get(cur).size(); j++) {
                    int next = g.get(cur).get(j);
                    int x = --indegree[next];
                    if (x == 0 && vis[next] == false) {
                        queue.add(next);
                    }
                }
            }


        }

        //list转为array
//        Integer[] result = new Integer[res.size()];
//        return res.toArray(result);

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        //如果不能产生拓扑序列就返回空数组，而不是null
        if(result.length != numCourses){
            return new int[0];
        }
        return result;


    }




    public static void main(String[] args) {
        Q210 q = new Q210();
        int[][] r = {{0,1}};
        q.findOrder(2,r);


    }

}

