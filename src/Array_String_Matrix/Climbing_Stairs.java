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
        if (n <= 2) {
            return n;
        }
        int setp1 = 1;
        int step2 = 2;
        int stepn = 0;
        for (int i = 3; i <= n; ++i) {
            stepn = setp1+step2;
            setp1 = step2;
            step2 = stepn;
        }
        return stepn;
    }

}
