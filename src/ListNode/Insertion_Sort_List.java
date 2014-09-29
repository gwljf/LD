package ListNode;

import Basic_Structue.ListNode;

import java.util.List;

/**
 * Created by wlf on 9/19/14.
 */
public class Insertion_Sort_List {
    public static void main (String[] args) {
        int[] list = {-84,142,41,-17,-71,170,186,183,-21,-76,76,10,29,81,112,-39,-6,-43,58,41,111,33,69,97,-38,82,-44,-7,99,135,42,150,149,-21,-30,164,153,92,180,-61,99,-81,147,109,34,98,14,178,105,5,43,46,40,-37,23,16,123,-53,34,192,-73,94,39,96,115,88,-31,-96,106,131,64,189,-91,-34,-56,-22,105,104,22,-31,-43,90,96,65,-85,184,85,90,118,152,-31,161,22,104,-85,160,120,-31,144,115};

        ListNode dum = ListNode.create(list);
        dum.print();

        ListNode ret = insertionSortList(dum);
        ret.print();
    }
    public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = head;
        ListNode pre = dummyHead;
        ListNode ncur = pre.next;
        while(cur!=null){
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = null;
            while(true){
                if(ncur==null){             //用于插到队尾, 也是在插入第一个元素杜时候
                    pre.next = tmp;
                    break;
                } else if (tmp.val>ncur.val) {
                    pre=pre.next;
                    ncur=ncur.next;
                } else {
                    pre.next = tmp;
                    tmp.next = ncur;
                    break;
                }
            }
            pre = dummyHead;
            ncur = pre.next;
        }
        return dummyHead.next;
    }
}
