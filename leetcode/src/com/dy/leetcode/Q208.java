package com.dy.leetcode;

public class Q208 {
	public static class TrieNode {
		char val;
		char[] children;
	    // Initialize your data structure here.
	    public TrieNode() {
	        this.children = new char[26];
	    }
	    public TrieNode(char c) {
	    	this.val = c;
	        children = new char[26];
	    }
	}
	public int getIndex(String s, int i){
		return s.charAt(i)-'a';
	}
	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			int index = getIndex(s, 0);

		}

		// Returns if the word is in the trie.
		public boolean search(String word) {

		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {

		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");

}
