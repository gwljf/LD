package Array_String_Matrix;

/**
 * Created by wlf on 9/22/14.
 */
public class Gas_Station {
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int remain = 0;
        int index = 0;
        for(int i=0; i<len;){
            if(gas[i]-cost[i]>=0){
                index = i;
                remain = gas[i] - cost[i];
                while(remain>=0 && ++i<len){
                    remain += gas[i]-cost[i];
                }
            }else{
                ++i;
            }
        }
        remain = 0;
        for(int i=0; i<len; ++i){
            remain += gas[(index+i)%len]-cost[(index+i)%len];
            if(remain<0){
                return -1;
            }
        }
        return index;
    }
}
