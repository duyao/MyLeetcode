package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.dy.leetcode.Q56.Interval;
//直接法比二分更快！！！？？？
public class Q57_1 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0){
			result.add(newInterval);
			return result;
		}
		int i = 0;
		while(i < intervals.size() && intervals.get(i).end < newInterval.start){
			result.add(intervals.get(i));
			i++;
		}
		Interval ii = new Interval();
		if(i >= intervals.size()){
			ii.start = newInterval.start;
		}else{
			ii.start = Math.min(newInterval.start, intervals.get(i).start);
		}
		while(i < intervals.size() && intervals.get(i).start < newInterval.end){
			i++;
		}
		if(i > intervals.size() || i < 1){
			ii.end = newInterval.end;
		}else{
			ii.end = Math.max(newInterval.end, intervals.get(i-1).end);
			
		}
		if(i < intervals.size() && intervals.get(i).start == newInterval.end){
			ii.end = intervals.get(i).end;
			i++;
		}
		result.add(ii);
		while(i < intervals.size()){
			result.add(intervals.get(i));
			i++;
		}
		return result;
	}
	public static void main(String[] args) {
		Q57_1 q = new Q57_1();
		Interval i1 = new Interval(3, 4);
		Interval i2 = new Interval(5, 6);
		Interval i3 = new Interval(9, 15);
		Interval i4 = new Interval(17, 22);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		Interval newInterval = new Interval(1, 3);
		list = q.insert(list, newInterval);
		System.out.println(list);

	}

}
