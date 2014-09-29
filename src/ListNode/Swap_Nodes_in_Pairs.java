package ListNode;

import Basic_Structue.ListNode;

/**
 * Created by wlf on 9/28/14.
 */
/*

Given a linked list, swap every two adjacent nodes and return its head.

        For example,
        Given 1->2->3->4, you should return the list as 2->1->4->3.

        Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

public class Swap_Nodes_in_Pairs {

    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode pre = dummyhead;
        ListNode cur = head;
        ListNode tmp;
        while(cur!=null){
            if(cur.next!=null){
                tmp=cur.next;
                cur.next=cur.next.next;
                tmp.next=cur;
                pre.next=tmp;
                pre=pre.next.next;
                cur=cur.next;
            }else{
                cur=cur.next;
            }
        }
        return dummyhead.next;
    }
}
