package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q56 {
	public static class Interval 
	//implements Comparable<Interval>
	{
		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

//		@Override
//		public int compareTo(Interval o) {
//			if(this.start < o.start){
//				return -1;
//			}else if(this.start > o.start){
//				return 1;
//			}else{
//				if(this.end < o.end){
//					return -1;
//				}else{
//					return 1;
//				}
//			}
//		}
	}
	
	
	

	public List<Interval> merge(List<Interval> intervals) {
		if(intervals.size() < 2){
			return intervals;
		}
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				//java.lang.IllegalArgumentException: Comparison method violates its general contract!
//				if(o1.start < o2.start){
//					return -1;
//				}else if(o1.start > o2.start){
//					return 1;
//				}else{
//					if(o1.end <= o2.end){
//						return -1;
//					}else{
//						return 1;
//					}
//				}
				return Integer.compare(o1.start, o2.start);
			}
			
			
		});
		List<Interval> tmp = intervals;
		System.out.println(intervals);
		int cnt = 1;
		while(cnt < intervals.size()){
			Interval b = intervals.get(cnt);
			Interval a = intervals.get(cnt-1);
			if(b.start <= a.end){
				Interval c = new Interval(a.start, Math.max(a.end, b.end));
				tmp.remove(a);
				tmp.remove(b);
				tmp.add(cnt-1,c);
			}else{
				cnt++;
			}
			intervals = tmp;
		}
		
//		for(int i =1; i < intervals.size(); i++){
//			Interval b = intervals.get(i);
//			Interval a = intervals.get(i-1);
//			if(b.start <= a.end){
//				Interval c = new Interval(a.start, b.end);
//				tmp.remove(a);
//				tmp.remove(b);
//				tmp.add(i-1,c);
//			}
//			intervals = tmp;
//		}
		System.out.println(intervals);
		return intervals;

	}
	public static void main(String[] args) {
		Interval i1 = new Interval(1, 4);
		Interval i2 = new Interval(2, 3);
		Interval i3 = new Interval(4, 5);
		Interval i4 = new Interval(1, 2);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		Q56 q = new Q56();
		list = q.merge(list);
		
	}

}
