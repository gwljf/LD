package Combinations_and_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wlf on 9/17/14.
 */
public class Subsets {
/*

    Given a set of distinct integers, S, return all possible subsets.

            Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
     For example,
    If S = [1,2,3], a solution is:

    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
*/

    public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> done = new ArrayList<Integer>();
        if (S.length == 0) {
            return ret;
        }
        Arrays.sort(S);
        ret.add(new ArrayList<Integer>());
        rec(S, ret, done, 0);
        return ret;
    }

    public static void rec(int[] S, List<List<Integer>> ret, List<Integer> done, int curIndex) {
        for (int i = curIndex; i < S.length; ++i) {
            done.add(S[i]);
            ret.add(new ArrayList<Integer>(done));
            rec(S, ret, done, i + 1);
            done.remove(done.size() - 1);
        }
    }


}
