package Array_String_Matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wlf on 9/17/14.
 */
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] num) {
        if (num.length==0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int ele:num){
            set.add(ele);
        }

        int maxLen = 0;
        for(int i=0; i<num.length; ++i){
            int cur = num[i];
            int curLen = 1;
            int tmp = cur;
            while(set.contains(--tmp)){
                curLen++;
                set.remove(tmp);
            }
            tmp = cur;
            while(set.contains(++tmp)){
                curLen++;
                set.remove(tmp);
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
