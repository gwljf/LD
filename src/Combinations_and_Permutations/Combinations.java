package Combinations_and_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlf on 9/12/14.
 */


/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

        For example,
        If n = 4 and k = 2, a solution is:

        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]
*/

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> done = new ArrayList<Integer>();
        rec(n, k, ret, done, 1);
        return ret;
    }

    public static void rec(int n, int k, List<List<Integer>> ret, List<Integer> done, int cur) {
        if (done.size() == k) {
            ret.add(new ArrayList<Integer>(done));
            return;
        }

        for (int i = cur; i <= n; i++) {
            done.add(i);
            rec(n, k, ret, done, i + 1);      // 一定要注意是 i+1, 不是 cur+1
            done.remove(done.size() - 1);
        }
    }
}
