package com.dy.leetcode;

public class Q3 {
	public int lengthOfLongestSubstring(String s) {
        String res = "";
        StringBuffer sb = new StringBuffer();
        char [] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            if(sb.indexOf(String.valueOf(c[i]))==-1 ){
            	sb.append(c[i]);
            	
            }else{
            	int start = sb.indexOf(String.valueOf(c[i]));
            	if(start != -1){
            		sb = new StringBuffer(sb.substring(start+1));
            	}else{
            		sb = new StringBuffer();
            	}
            	sb.append(c[i]);
            }
            
            if(res.length() <= sb.length()){
        		res = sb.toString();
        	}
            
        }
        System.out.println(res);
        return res.length();
        
    }
	public static void main(String[] args) {
		Q3 q  = new  Q3();
		String s = "bbbbb";
		q.lengthOfLongestSubstring(s);
	}

}
