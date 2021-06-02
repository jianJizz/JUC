import com.usc.leetcode.ListNode;
import com.usc.leetcode.TreeNode;

import java.util.*;

/**
 * @author jianjianduan
 * @date 2020/10/4 6:51 下午
 */
public class Demo1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new Demo1().removeNthFromEnd(head, 2);
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
