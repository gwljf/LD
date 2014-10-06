package Array_String_Matrix;

/**
 * Created by wlf on 9/22/14.
 */
public class Gas_Station {

/*
    There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

    Note:
    The solution is guaranteed to be unique.
*/

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
