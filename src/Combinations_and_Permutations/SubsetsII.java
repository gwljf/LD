package Combinations_and_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wlf on 9/17/14.
 */
public class SubsetsII {
/*
    Given a collection of integers that might contain duplicates, S, return all possible subsets.

            Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

    For example,
    If S = [1,2,2], a solution is:

            [
            [2],
            [1],
            [1,2,2],
            [2,2],
            [1,2],
            []
            ]
*/

    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> done = new ArrayList<Integer>();
        if(num.length==0){
            return ret;
        }
        Arrays.sort(num);
        ret.add(new ArrayList<Integer>());
        rec(num, ret, done, 0);
        return ret;
    }

    public static void rec(int[] S, List<List<Integer>> ret, List<Integer> done, int curIndex){
        for(int i=curIndex; i<S.length; ++i){
            done.add(S[i]);
            ret.add(new ArrayList<Integer>(done));
            rec(S, ret, done, i+1);
            done.remove(done.size()-1);
            while(i+1<S.length&&S[i]==S[i+1]){
                i++;
            }
        }
    }

}
