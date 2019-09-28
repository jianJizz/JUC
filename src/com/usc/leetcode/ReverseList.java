package com.usc.leetcode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList {

    public static void main(String[] args) {

    }

    //迭代
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            // 每次都把pre指向curr.next 然后再让curr指向pre
            // pre= null
            // curr = 1 ->2 -> 3 ->4
            //pre指向curr.next
            // curr = 1 -> null
            //curr指向pre
            // pre = 1 -> null
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }


    //递归
    public ListNode reverseList2(ListNode head) {
        return null;
    }

   /* public void help(ListNode head, ListNode curr){
        if (head.next == null ) {
            curr.next = new ListNode(head.val);
        }
        head = head.next;
        help(head);
    }*/
}
