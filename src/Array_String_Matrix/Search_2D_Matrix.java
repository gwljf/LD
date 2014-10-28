package Array_String_Matrix;

/**
 * Created by wlf on 9/17/14.
 */
public class Search_2D_Matrix {
    /*
        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.

        For example,

        Consider the following matrix:

                [
                [1,   3,  5,  7],
                [10, 11, 16, 20],
                [23, 30, 34, 50]
                ]

        Given target = 3, return true.
        */
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length * matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
