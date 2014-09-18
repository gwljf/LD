package Combinations_and_Permutations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wlf on 9/12/14.
 */



public class Combination_Sum {

/*
        Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

        The same repeated number may be chosen from C unlimited number of times.

        Note:
        All numbers (including target) will be positive integers.
        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        The solution set must not contain duplicate combinations.
        For example, given candidate set 2,3,6,7 and target 7,
        A solution set is:
        [7]
        [2, 2, 3]
        [2, 2, 3]
*/

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> done = new ArrayList<Integer>();
        Arrays.sort(candidates);                        // 因为第二个条件,所以必须先排序一下
        rec(ret, done, candidates, target, 0, 0);
        return  ret;
    }

    public static void rec(List<List<Integer>> ret, List<Integer> done, int[] candidates, int target, int curIndex, int curSum) {
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            ret.add(new ArrayList<Integer>(done));
            return;
        }
        for (int i=curIndex; i<candidates.length; i++) {
            done.add(candidates[i]);
            curSum += candidates[i];
            rec(ret, done, candidates, target, curIndex, curSum);
            curSum -= candidates[i];
            done.remove(done.size()-1);
        }
    }

/*
    Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

    Each number in C may only be used once in the combination.

    Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 10,1,2,7,6,1,5 and target 8,
    A solution set is:
            [1, 7]
            [1, 2, 5]
            [2, 6]
            [1, 1, 6]
*/

    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> done = new ArrayList<Integer>();
        Arrays.sort(num);
        rec1(ret, done, num, target, 0, 0);
        return ret;
    }

    public static void rec1(List<List<Integer>> ret, List<Integer> done, int[] num, int target, int curIndex, int curSum) {
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            ret.add(new ArrayList<Integer>(done));
            return;
        }
        for (int i=curIndex; i<num.length; i++) {
            done.add(num[i]);
            curSum += num[i];
            rec1(ret, done, num, target, i+1, curSum);
            curSum -= num[i];
            done.remove(done.size()-1);

            while (i+1 < num.length && num[i]==num[i+1]) {
                i++;
            }
        }
    }

}
