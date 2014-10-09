package ListNode;

import Basic_Structue.ListNode;

/**
 * Created by wlf on 10/8/14.
 */
public class Remove_Nth_Node_From_End_of_List {

/*
    Given a linked list, remove the nth node from the end of list and return its head.

    For example,

    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.

    Note:
    Given n will always be valid.
    Try to do this in one pass.
*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next=head;

        ListNode p2 = dummyhead;
        int count=0;
        while(count<n){
            p2=p2.next;
            ++count;
        }
        ListNode p1 = dummyhead;
        while(p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p1.next=p1.next.next;
        return dummyhead.next;
    }
}
