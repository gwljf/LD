package Combinations_and_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wlf on 9/12/14.
 */
public class Permutations {         // 有没有想等的值


    public static void main (String[] args) {

    }


/*
    Given a collection of numbers, return all possible permutations.

            For example,
    [1,2,3] have the following permutations:
            [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> al = new ArrayList<Integer>();
        rec(num, ret, al);
        return ret;
    }

    public static void rec(int[] num, List<List<Integer>> ret, List<Integer> al) {
        if (num.length == 0) {
            ret.add(new ArrayList<Integer>(al));        // 一定要注意
            return;
        }
        for (int i=0; i<num.length; i++) {
            al.add(num[i]);
            int[] sub = new int[num.length-1];
            System.arraycopy(num, 0, sub, 0, i);
            System.arraycopy(num, i+1, sub, i, num.length-i-1);
            rec(sub,ret,al);
            al.remove(al.size()-1);
        }
    }


/*
    Given a collection of numbers that might contain duplicates, return all possible unique permutations.

    For example,
    [1,1,2] have the following unique permutations:
            [1,1,2], [1,2,1], and [2,1,1].
*/
    public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> done = new ArrayList<Integer>();
        Arrays.sort(num);
        rec1(num, ret, done);
        return ret;
    }

    public static void rec1 (int[] num, List<List<Integer>> ret, List<Integer> done) {

        if (num.length == 0) {
            ret.add(new ArrayList<Integer>(done));
            return;
        }
        for (int i=0; i<num.length; i++) {
            done.add(num[i]);
            int[] sub = new int[num.length-1];
            System.arraycopy(num, 0, sub, 0, i);
            System.arraycopy(num, i+1, sub, i, num.length-1-i);
            rec1(sub, ret, done);
            done.remove(done.size()-1);
            while (i+1<num.length && num[i+1] == num[i]) {
                i++;
            }
        }
    }
}
