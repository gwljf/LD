package Array_String_Matrix;

import Basic_Structue.Interval;

import java.util.*;

/**
 * Created by wlf on 10/8/14.
 */
public class Merge_Intervals {
    /*    Given a collection of intervals, merge all overlapping intervals.

        For example,
        Given [1,3],[2,6],[8,10],[15,18],
                return [1,6],[8,10],[15,18].
    */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new IntervalComparator());        // 先排序
        List<Interval> ret = new ArrayList<Interval>();
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); ++i) {
            Interval cur = intervals.get(i);
            if (pre.end < cur.start) {       // no overlap
                ret.add(pre);
                pre = cur;
            } else {
                pre = new Interval(pre.start, Math.max(pre.end, cur.end));
            }
        }
        ret.add(pre);
        return ret;
    }

    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval v1, Interval v2) {
            return v1.start - v2.start;
        }
    }
}






