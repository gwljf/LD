package BinaryTree_Traversal;

/**
 * Created by wlf on 9/17/14.
 */
public class Unique_Binary_Search_Trees {

    public static int numTrees(int n) {
        return num(n);
    }

    public static int num(int n){
        if(n==0 || n==1){
            return 1;           // 因为是可能性,所以无论n=0或1都只有一种可能
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        for(int i=1; i<=n; ++i){
            left = num(i-1);
            right = num(n-i);
            sum += left*right;
        }
        return sum;
    }
}
