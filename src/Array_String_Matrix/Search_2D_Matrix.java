package Array_String_Matrix;

/**
 * Created by wlf on 9/17/14.
 */
public class Search_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0, matrix.length*matrix[0].length-1);
    }

    public boolean search(int[][] matrix, int target, int low, int high){
        if(low>high){
            return false;
        }
        int mid = low+(high-low)/2;

        int row = mid/matrix[0].length;
        int col = mid%matrix[0].length;

        if (matrix[row][col]==target) {
            return true;
        } else if(matrix[row][col]<target){
            return search(matrix, target, mid+1, high);
        } else {
            return search(matrix, target, low, mid-1);
        }
    }

}
