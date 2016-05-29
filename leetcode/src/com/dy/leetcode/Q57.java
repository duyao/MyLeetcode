package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.dy.leetcode.Q56.Interval;

public class Q57 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals == null || intervals.size()== 0){
			intervals.add(newInterval);
			return intervals;
		}
		int start = 0;
		int end = intervals.size();
		while (start < end) {
			int mid = (start + end) / 2;
			if (intervals.get(mid).end <= newInterval.start) {
				start = mid + 1;
			} else {
				end = mid;
			}
			// 返回start，表示第一个比x大的位置
		}
		if (start >= intervals.size()) {
			//[1,2],add[2,3]
			if(newInterval.start == intervals.get(intervals.size()-1).end){
				intervals.get(intervals.size()-1).end = newInterval.end;
			}else{
				intervals.add(newInterval);
			}
		} else {
			// 记录开始位置，后面进行删除
			int dels = start;
			Interval ii = new Interval();
			ii.start = Math.min(newInterval.start, intervals.get(dels).start);
			// start...
			end = intervals.size();
			while (start < end) {
				int mid = (start + end) / 2;
				if (intervals.get(mid).start <= newInterval.end) {
					start = mid + 1;
				} else {
					end = mid;
				}
				// 返回start，表示第一个比x大的位置
			}

			// 需要最后一个比x小的位置
			if (start >= intervals.size() || intervals.get(start).start > newInterval.end) {
				start--;
			}
			if (start < dels) {
				//[1,2],[4,5],add[2,3]
				//[1,2],[4,5],add[2,2]
				if(start >= 0 && newInterval.start == intervals.get(start).end){
					intervals.get(start).end = Math.max(newInterval.end, intervals.get(start).end);
				}else{
					intervals.add(dels, newInterval);
				}
			} else {
				ii.end = Math.max(newInterval.end, intervals.get(start).end);
				for (int i = dels; i <= start; i++) {
					intervals.remove(dels);
				}
				intervals.add(dels, ii);
			}
			if(dels > 0 && intervals.get(dels-1).end == intervals.get(dels).start){
				
				intervals.get(dels).start = intervals.get(dels-1).start;
				intervals.remove(dels-1);
			}
		}
		return intervals;

	}

	public static void main(String[] args) {
		Q57 q = new Q57();
		Interval i1 = new Interval(3, 4);
		Interval i2 = new Interval(5, 6);
		Interval i3 = new Interval(9, 15);
		Interval i4 = new Interval(17, 22);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		Interval newInterval = new Interval(1, 2);
		q.insert(list, newInterval);
		System.out.println(list);

	}
}
