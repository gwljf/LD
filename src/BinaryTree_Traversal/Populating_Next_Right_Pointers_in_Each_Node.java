package BinaryTree_Traversal;

import Basic_Structue.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wlf on 9/17/14.
 */
public class Populating_Next_Right_Pointers_in_Each_Node {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        int curLen = 1;
        int nextLen = 0;
        while(!queue.isEmpty()){
            TreeLinkNode head = null;
            for(int i=1; i<=curLen; i++){
                TreeLinkNode tmp = queue.poll();
                if(tmp.right!=null){
                    queue.offer(tmp.right);
                    nextLen++;
                }
                if(tmp.left!=null){
                    queue.offer(tmp.left);
                    nextLen++;
                }
                tmp.next = head;
                head = tmp;
            }
            curLen = nextLen;
            nextLen = 0;
        }
    }
}
