package Array_String_Matrix;

/**
 * Created by wlf on 10/7/14.
 */
public class Climbing_Stairs {
/*
    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] ways = new int[n];
        ways[0]=1;
        ways[1]=2;
        for(int i=2; i<n; ++i){
            ways[i] = ways[i-1]+ways[i-2];
        }
        return ways[n-1];
    }

}
