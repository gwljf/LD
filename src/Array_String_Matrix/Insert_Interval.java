package Array_String_Matrix;

import Basic_Structue.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlf on 10/8/14.
 */
public class Insert_Interval {
/*    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.

    Example 1:
    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

    Example 2:
    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<Interval>();
        for(Interval ele : intervals){
            if(ele.end<newInterval.start){
                ret.add(ele);
            }else if(newInterval.end<ele.start){
                ret.add(newInterval);
                newInterval=ele;
            }else{                                          // overlap
                newInterval = new Interval(Math.min(ele.start, newInterval.start), Math.max(ele.end, newInterval.end));
            }
        }
        ret.add(newInterval);
        return ret;
    }
}
