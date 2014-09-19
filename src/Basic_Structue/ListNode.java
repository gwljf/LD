package Basic_Structue;

/**
 * Created by wlf on 8/22/14.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode (int _val) {
        this.val = _val;
        next = null;
    }

    public static ListNode create(int[] array) {
        if (array.length==0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int ele:array){
            cur.next = new ListNode(ele);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void print(ListNode head){
        ListNode cur = head;
        while (cur!=null){
            if (cur.next==null){
                System.out.print(cur.val+"");
            }else {
                System.out.print(cur.val+"->");
            }
        }
    }
}
