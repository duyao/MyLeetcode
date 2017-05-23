package com.dy.leetcode;

import java.util.*;

/**
 * Created by amy on 2017/2/23.
 */
public class Q399 {

    class Node {
        String s;
        double val;

        Node(String s, double val) {
            this.s = s;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "s='" + s + '\'' +
                    ", val=" + val +
                    '}';
        }
    }


    boolean b = false;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        HashMap<String, List<Node>> map = new HashMap<>();

        HashMap<String, String> father = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<Node> list = map.get(equations[i][0]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(new Node(equations[i][1], values[i]));
            map.put(equations[i][0], list);

            list = map.get(equations[i][1]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(new Node(equations[i][0], 1.0 / values[i]));
            map.put(equations[i][1], list);


        }

        for (int i = 0; i < queries.length; i++) {
            b = false;
            if (!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1])) {
                res[i] = -1.0;
            } else {
                if (queries[i][1].equals(queries[i][0])) {
                    res[i] = 1.0;
                } else {

                    res[i] = dfs(queries[i][0], queries[i][1], map, 1.0, new HashSet<>());
                    res[i] = b == true ? res[i] : -1.0;
                }

            }
        }

        //System.out.println(map);
        return res;
    }

    //如果能进入dfs，那么一定是可以有结果的
    public double dfs(String s, String e, HashMap<String, List<Node>> map, double x, HashSet<String> vis) {
        double res = 1.0;
        List<Node> nexts = map.get(s);
        vis.add(s);

        for (int i = 0; i < nexts.size(); i++) {
            Node cur = nexts.get(i);
            if (!vis.contains(cur.s)) {
                if (cur.s.equals(e)) {
                    b = true;
                    return x * cur.val;
                } else {
                    x *= cur.val;
                    res *= dfs(cur.s, e, map, x, vis);
                    x /= cur.val;

                }
            }

        }

        return res;
        //return Double.compare(-1.0, res) == 0 ? -1.0 : Math.abs(res);
    }

    public static void main(String[] args) {
        System.out.println(Double.compare(-1.0, 1.0));
        String[][] equations = {{"a", "b"}, {"e", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        Q399 q = new Q399();
        double[] res = q.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(res));
    }
}

