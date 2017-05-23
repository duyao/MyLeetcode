package com.dy.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//tle
//找邻居的时候三次循环，wordList*单词长度*26
//利用的是hashset.contains()的O(1)复杂度
public class Q127_1 {
	public static HashSet<String> getNext(String s, Set<String> wordList){
		HashSet<String> res = new HashSet<String>();
		for (int i = 0; i < s.length(); i++) {
			char[] c = s.toCharArray();
			for(char cc = 'a'; cc <= 'z'; cc++){
				c[i] = cc;
				String ss = new String(c);
				if(wordList.contains(ss)){
					res.add(ss);
				}
			}
		}
		return res;
		
	}
	
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		if(wordList == null || wordList.size() == 0){
			return 0;
		}
		
		wordList.add(beginWord);
		wordList.add(endWord);
		
		//一边遍历一边找到next
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		int cnt = 0;
		while(!queue.isEmpty()){
			int x = queue.size();
			for (int i = 0; i < x; i++) {
				String cur = queue.poll();
				if(cur.equals(endWord)){
					return cnt + 1;
				}
				wordList.remove(cur);
				for (String next : getNext(cur, wordList)) {
					if(wordList.contains(next)){
						queue.add(next);
					}
				}
				
			}
			cnt++;
		}
		return 0;
		
		
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = { "hot", "dot", "dog", "lot", "log" };
		Set<String>	set = new HashSet<String>();
		for (String s : wordList) {
			set.add(s);
		}
		Q127_1 q = new Q127_1();
		int x = q.ladderLength(beginWord, endWord, set);
		System.out.println(x);
		
	}
}
