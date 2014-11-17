package Array_String_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wlf on 11/17/14.
 */
public class Four_Sum {
/*
    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

            Note:
    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
            (-1,  0, 0, 1)
            (-2, -1, 1, 2)
            (-2,  0, 0, 2)
*/

    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        if(num.length<4){
            return ret;
        }
        Arrays.sort(num);
        for(int i=0; i<num.length-3; ++i){
            if(i>0 && num[i]==num[i-1]){
                continue;
            }
            for(int j=i+1; j<num.length-2; ++j){
                if(j>(i+1) && num[j]==num[j-1]){  //j>(i+1)
                    continue;
                }
                int low=j+1, high=num.length-1;
                while(low<high){
                    if((num[low]+num[high])==(target-num[i]-num[j])){
                        solution.add(num[i]);
                        solution.add(num[j]);
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
                    } else if((num[low]+num[high])<(target-num[i]-num[j])){
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
        }
        return ret;
    }
}
