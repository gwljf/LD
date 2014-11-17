package Array_String_Matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wlf on 11/16/14.
 */
public class Two_Sum {
/*
    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

    You may assume that each input would have exactly one solution.

            Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
*/

    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        if(numbers.length<=1){
            return ret;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // value, index
        int index=0;
        while(index<numbers.length){
            if(map.containsKey(target-numbers[index])){
                ret[0] = map.get(target-numbers[index])+1;
                ret[1] = index+1;
                return ret;
            }else{
                map.put(numbers[index],index);
                ++index;
            }
        }
        return ret;
    }
}
