package Array_String_Matrix;

/**
 * Created by wlf on 9/17/14.
 */
public class Sort_Colors {

/*
    Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/

    public void sortColors(int[] A) {
        if(A.length==0){
            return;
        }
        int p1=0, p2=A.length-1, i=0;
        while(i<=p2){
            if(A[i]==1){
                i++;
            }else if(A[i]==0){
                swap(A,p1,i);
                p1++;
                i++;
            }else if(A[i]==2){
                swap(A,i,p2);
                p2--;
            }
        }
    }

    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
        return;
    }

}
