package Array_String_Matrix;

/**
 * Created by wlf on 10/7/14.
 */
public class Set_Matrix_Zeroes {

/*    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.*/

    public void setZeroes(int[][] matrix) {
        if(matrix.length==0){
            return;
        }

        boolean rowZero = false, colZero = false;

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        ////////////////////////////////////////////
        for(int i=0; i<rowNum; i++){
            if(matrix[i][0]==0){
                colZero = true;
            }
        }

        for(int j=0; j<colNum; j++){
            if(matrix[0][j]==0){
                rowZero = true;
            }
        }

        ////////////////////////////////////////////
        for(int i=1; i<rowNum; i++){
            for(int j=1; j<colNum; j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        /////////////////////////////////////////////
        for(int i=1; i<rowNum; i++){
            for(int j=1; j<colNum; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        ////////////////////////////////////////////
        if(rowZero){
            for(int j=0; j<colNum; j++){
                matrix[0][j] = 0;
            }
        }
        if(colZero){
            for(int i=0; i<rowNum; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
