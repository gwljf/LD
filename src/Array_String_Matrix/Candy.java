package Array_String_Matrix;

/**
 * Created by wlf on 9/22/14.
 */
public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1, 2, 1};
        System.out.println(candy(ratings));
    }
/*

    There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

    What is the minimum candies you must give?
*/


    public static int candy(int[] ratings) {
        int len = ratings.length;
        if (len == 0 || len == 1) {
            return len;
        }

        int[] candy = new int[len];
        int cur = 1;
        for (int i = 1; i < len; ++i) {
            if (ratings[i] > ratings[i - 1]) {        // 后面的比前面杜大
                cur++;
            } else {
                cur = 1;
            }
            candy[i] = cur;
        }
        cur = 1;
        for (int i = len - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {            // 前面杜比后面的大
                cur++;
            } else {
                cur = 1;
            }
            candy[i] = Math.max(cur, candy[i]);
        }
        int min = 0;
        for (int i = 0; i < len; ++i) {
            min += candy[i];
        }
        return min;
    }
}
