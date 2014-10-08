package Array_String_Matrix;

/**
 * Created by wlf on 10/7/14.
 */
public class Unique_Paths {
/*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?


    Above is a 3 x 7 grid. How many possible unique paths are there?

    Note: m and n will be at most 100.
*/
    public int uniquePaths(int m, int n) {
        if(m<1 || n<1){
            return 0;
        }
        int row = m;
        int col = n;
        int[][] matrix = new int[m][n];
        for(int i=0; i<row; i++){
            matrix[i][0] = 1;
        }
        for(int j=1; j<col; j++){
            matrix[0][j] = 1;
        }
        int i, j, x=1, y=1;
        for(i=x; i<row; i++){
            for(j=y; j<col; j++){
                matrix[i][j] = matrix[i][j-1]+matrix[i-1][j];
            }
        }
        return matrix[m-1][n-1];
    }


/*
    Follow up for "Unique Paths":

    Now consider if some obstacles are added to the grids. How many unique paths would there be?

    An obstacle and empty space is marked as 1 and 0 respectively in the grid.

    For example,

    There is one obstacle in the middle of a 3x3 grid as illustrated below.

    [
            [0,0,0],
            [0,1,0],
            [0,0,0]
            ]

    The total number of unique paths is 2.
*/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] matrix = obstacleGrid;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]==1){
                    matrix[i][j]=-1;
                }
            }
        }
        if(matrix[0][0]==-1){
            return 0;
        }else{
            matrix[0][0]=1;
        }
        for(int i=1; i<row; i++){
            if(matrix[i-1][0]==-1){
                matrix[i][0]=-1;
            }else if(matrix[i][0]!=-1){
                matrix[i][0]=1;
            }
        }
        for(int j=1; j<col; j++){
            if(matrix[0][j-1]==-1){
                matrix[0][j]=-1;
            }else if(matrix[0][j]!=-1){
                matrix[0][j]=1;
            }
        }

        int i,j,x=1,y=1;
        for(i=x; i<row; i++){
            for(j=y; j<col; j++){
                if(matrix[i][j]==-1){
                    continue;
                }
                if(matrix[i-1][j]!=-1 && matrix[i][j-1]!=-1){
                    matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
                }else if(matrix[i-1][j]!=-1){
                    matrix[i][j]=matrix[i-1][j];
                }else if(matrix[i][j-1]!=-1){
                    matrix[i][j]=matrix[i][j-1];
                }else{
                    matrix[i][j]=-1;
                }
            }
        }
        if(matrix[row-1][col-1]==-1){
            return 0;
        }else{
            return matrix[row-1][col-1];
        }
    }
}
