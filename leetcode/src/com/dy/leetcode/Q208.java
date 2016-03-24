package com.dy.leetcode;

public class Q208 {
	public static class TrieNode {
		char val;
		TrieNode[] children;
		boolean leaf;

		// Initialize your data structure here.
		public TrieNode() {
			this.children = new TrieNode[26];
			leaf = false;
		}

		public TrieNode(char c) {
			this.val = c;
			children = new TrieNode[26];
			leaf = false;
		}
	}


	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();

		}

		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i) - 'a';
				TrieNode tmp = cur.children[index];
				if (tmp == null) {
					tmp = new TrieNode(word.charAt(i));
					cur.children[index] = tmp;
				}
				if (i == word.length() - 1) {
					tmp.leaf = true;
				}
				cur = tmp;

			}
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i) - 'a';
				TrieNode tmp = cur.children[index];
				if (tmp != null) {
					if (i == word.length() - 1 && tmp.leaf) {
						return true;
					}
					cur = tmp;
				} else {
					// �޴˽ڵ�
					return false;
				}

			}
			return false;

		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode cur = root;
			for (int i = 0; i < prefix.length(); i++) {
				int index = prefix.charAt(i) - 'a';
				TrieNode tmp = cur.children[index];
				if (tmp != null) {
					cur = tmp;
				} else {
					// �޴˽ڵ�
					return false;
				}

			}
			//prefix�Ǹ��ַ���Ҳ����
			return true;

		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");

	public static void main(String[] args) {
		Trie trie = new Trie();
//		trie.insert("some");
//		trie.insert("somestring");
		trie.insert("a");
		boolean b = trie.search("a");
		boolean bb = trie.startsWith("a");
		System.out.println(b);
		System.out.println(bb);
	}

}
