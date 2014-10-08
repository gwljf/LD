package Array_String_Matrix;

import java.util.List;

/**
 * Created by wlf on 10/7/14.
 */
public class Triangle {
/*

    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

    For example, given the following triangle

    [
            [2],
            [3,4],
            [6,5,7],
            [4,1,8,3]
            ]

    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

    Note:
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/
    public int minimumTotal(List<List<Integer>> triangle) {
        int hight = triangle.size();

        int[] value = new int[hight];
        for(int i=0; i<hight; ++i){
            value[i] = triangle.get(hight-1).get(i);
        }

        for(int curHight=hight-2; curHight>=0; --curHight){
            for(int index=0; index<=curHight; ++index){
                value[index] = Math.min(triangle.get(curHight).get(index)+value[index], triangle.get(curHight).get(index)+value[index+1]);
            }
        }
        return value[0];
    }
}
