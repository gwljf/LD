package Array_String_Matrix;

/**
 * Created by wlf on 10/6/14.
 */
public class Rotate_Image {
    /*
        You are given an n x n 2D matrix representing an image.

        Rotate the image by 90 degrees (clockwise).

        Follow up:
        Could you do this in-place?
        顺时针:   上下交换,然后对角线交换
        逆时针:   左右交换,然后对角线交换
      */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int col = 0; col < len; ++col) {
            for (int row = 0; row < len / 2; ++row) {
                swap(matrix, row, col, len - 1 - row, col);
            }
        }
        for (int row = 0; row < len; ++row) {
            for (int col = row; col < len; ++col) {
                swap(matrix, row, col, col, row);
            }
        }
    }

    public void swap(int[][] matrix, int x, int y, int _x, int _y) {
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[_x][_y];
        matrix[_x][_y] = tmp;
    }
}
