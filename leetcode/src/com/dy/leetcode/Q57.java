package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.dy.leetcode.Q56.Interval;

public class Q57 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int start = 0;
		int end = intervals.size();
		while(start < end){
			int mid = (start + end) / 2;
			if(intervals.get(mid).end <= newInterval.start){
				start = mid;
			}else{
				end = mid - 1;
			}
			//返回start，表示第一个比x大的位置
		}
		if(start >= intervals.size()){
			intervals.add(newInterval);
		}else{
			//记录开始位置，后面进行删除
			int dels = start;
			Interval ii = new Interval();
			ii.start = Math.min(newInterval.start, intervals.get(dels).start);
			// start...
			end = intervals.size();
			while(start < end){
				int mid = (start + end) / 2;
				if(intervals.get(mid).start <= newInterval.end){
					start = mid;
				}else{
					end = mid - 1;
				}
				//返回start，表示第一个比x大的位置
			}
			
			//需要最后一个比x小的位置
			if(intervals.get(start).start > newInterval.end){
				start--;
			}
			if(start < dels){
				intervals.add(dels, newInterval);
			}else{
				ii.end = Math.max(newInterval.end, intervals.get(start).end);
				for (int i = dels; i <= start; i++) {
					intervals.remove(dels);
				}
				intervals.add(dels, ii);
			}
		}
		return intervals;
		
	}
	public static void main(String[] args) {
		Q57 q = new Q57();
		Interval i1 = new Interval(2, 4);
		Interval i2 = new Interval(5, 6);
		Interval i3 = new Interval(9, 15);
		Interval i4 = new Interval(17, 22);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		Interval newInterval = new Interval(5,14);
		q.insert(list, newInterval);
		System.out.println(list);
		
	}
}
