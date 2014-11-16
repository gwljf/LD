package Array_String_Matrix;

/**
 * Created by wlf on 11/15/14.
 */
public class Edit_Distance {
/*

    Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:

    a) Insert a character
    b) Delete a character
    c) Replace a character
*/


    public int minDistance(String word1, String word2) {
        int[][] board = new int[word1.length()+1][word2.length()+1];

        for(int i=1; i<=word1.length(); ++i){
            board[i][0]=i;
        }
        for(int j=1; j<=word2.length(); ++j){
            board[0][j]=j;
        }
        for(int i=1; i<=word1.length(); ++i){
            for(int j=1; j<=word2.length(); ++j){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    board[i][j]=board[i-1][j-1];
                }else{
                    int replace = board[i-1][j-1]+1;
                    int add = board[i][j-1]+1;
                    int del = board[i-1][j]+1;
                    board[i][j] = Math.min(replace, Math.min(add, del));
                }
            }
        }
        return board[word1.length()][word2.length()];
    }
}
