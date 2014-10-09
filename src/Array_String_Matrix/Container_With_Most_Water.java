package Array_String_Matrix;

/**
 * Created by wlf on 10/9/14.
 */
public class Container_With_Most_Water {
/*
    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

            Note: You may not slant the container.
*/
    public int maxArea(int[] height) {
        int len=height.length;
        if(len <= 1){
            return 0;
        }
        int i=0, j=len-1;
        int max=(j-i)*Math.min(height[i], height[j]);

        while(i<j){
            if(height[i] <= height[j]){
                ++i;
                max=Math.max(max, (j-i)*Math.min(height[i], height[j]));
            } else {
                --j;
                max=Math.max(max, (j-i)*Math.min(height[i], height[j]));
            }
        }
        return max;
    }
}
