package com.dy.leetcode;

import com.dy.leetcode.Q133.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by amy on 2017/3/6.
 */
public class Q133_1 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        LinkedList<UndirectedGraphNode> que = new LinkedList<>();
        que.add(node);
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node.label, root);
        while (!que.isEmpty()) {
            UndirectedGraphNode cur = que.pop();
            UndirectedGraphNode newcur = map.get(cur.label);

            //加入遍历的队列
            for (UndirectedGraphNode ug :
                    cur.neighbors) {
                if (!map.containsKey(ug.label)) {
                    que.add(ug);
                    map.put(ug.label, new UndirectedGraphNode(ug.label));
                }
                //为当前新节点添加nei
                newcur.neighbors.add(map.get(ug.label));
//                newcur.neighbors.add(map.containsKey(ug.label) ? map.get(ug.label) : new UndirectedGraphNode(ug.label));

            }


        }

        return map.get(node.label);


    }

    public static void main(String[] args) {
        UndirectedGraphNode root = new UndirectedGraphNode(1);
        UndirectedGraphNode n1 = new UndirectedGraphNode(2);
		UndirectedGraphNode n2 = new UndirectedGraphNode(3);
        root.neighbors.add(n1);
		n1.neighbors.add(n2);
//		n1.neighbors.add(root);
//		n2.neighbors.add(n1);
//		root.neighbors.add(root);

        Q133_1 q = new Q133_1();
        UndirectedGraphNode res = q.cloneGraph(root);
        System.out.println(res.neighbors.size());
    }

}
