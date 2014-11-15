package Array_String_Matrix;

/**
 * Created by wlf on 11/15/14.
 */
public class Jump_Game {

    public static void main(String[] args){
        Jump_Game test = new Jump_Game();
        boolean ret = test.canJump(new int[]{2,4,2,1,0,4});
        System.out.println(ret);
    }

    public boolean canJump(int[] A) {
        int len = A.length;
        if(len==0){
            return true;
        }
        int startIndexcanReach=len-1;
        for(int i=len-2; i>=0; --i){
            if (A[i]+i>=startIndexcanReach){
                startIndexcanReach = i;
            }
        }
        return startIndexcanReach==0 ? true:false;
    }
}
