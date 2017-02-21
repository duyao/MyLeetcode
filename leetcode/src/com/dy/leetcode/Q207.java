package com.dy.leetcode;


import java.util.*;

/**
 * Created by think on 2017-02-21.
 */
public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] incnt = new int[numCourses];
        boolean[] vis = new boolean[numCourses];
        ArrayList<List<Integer>> g = new ArrayList<>();
        int vcnt = 0;
        //初始化
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
            vis[i] = false;
            incnt[i] = 0;
        }
        for (int i = 0; i < prerequisites.length; i++) {
            incnt[prerequisites[i][0]]++;
            g.get(prerequisites[i][1]).add(prerequisites[i][0]);

        }

        Queue<Integer> queue = new LinkedList<>();


        for (int i = 0; i < numCourses; i++) {
            if (incnt[i] == 0) {
                queue.add(i);
            }
        }




        while (!queue.isEmpty()) {
            vcnt++;
            int cur = queue.poll();
            vis[cur] = true;
            for (int i = 0; i < g.get(cur).size(); i++) {
                int x = --incnt[g.get(cur).get(i)];
                if (x == 0 && vis[g.get(cur).get(i)] == false) {
                    //添加到队列中
                    queue.add(g.get(cur).get(i));
                    g.get(cur).remove(i);
                }


            }

        }


        return vcnt == numCourses;


    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,0},{2,0}};
        Q207 q = new Q207();
        boolean b = q.canFinish(3, prerequisites);
        System.out.println(b);

    }
}
