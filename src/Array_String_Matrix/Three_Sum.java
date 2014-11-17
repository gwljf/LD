package Array_String_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wlf on 11/17/14.
 */
public class Three_Sum {
/*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

            Note:
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
            (-1, 0, 1)
            (-1, -1, 2)
*/

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        if(num.length<3){
            return ret;
        }
        Arrays.sort(num);
        for(int i=0; i<num.length-2; ++i){
            if(i>0 && num[i]==num[i-1]){
                continue;
            }
            int low = i+1, high = num.length-1;
            while(low < high){
                if((num[low]+num[high])==(0-num[i])){
                    solution.add(num[i]);
                    solution.add(num[low]);
                    solution.add(num[high]);
                    ret.add(new ArrayList<Integer>(solution));
                    solution.clear();
                    do{
                        ++low;
                    }while(low<high && num[low]==num[low-1]);
                    do{
                        --high;
                    }while(low<high && num[high]==num[high+1]);
                } else if((num[low]+num[high])<(0-num[i])){
                    do{
                        ++low;
                    }while(low<high && num[low]==num[low-1]);
                } else{
                    do{
                        --high;
                    }while(low<high && num[high]==num[high+1]);
                }
            }
        }
        return ret;
    }
}
