package com.usc.leetcode;

import java.util.*;

/**
 *给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RemoveNthFromEnd.removeNthFromEnd2(head, 2);
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode curr = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int size = 0;
        while (curr != null){
            map.put(size++, curr);
            curr =  curr.next;
        }
        // 0 1->2->3->4->5
        // 1 2->3->4->5
        // 2 3->4->5
        // 3 4->5
        // 4 5->null
        int pre = size - n - 1;
        int last = size - n + 1;

        if (pre < 0 && last > size - 1) //[1] 1
            return null;
        if (pre < 0 ) head = map.get(last); //[1,2] 2
        if (last > size - 1) map.get(pre).next = null;  // [1,2] 1
        if (pre >= 0 && last <= size - 1) map.get(pre).next = map.get(last);

        return head;
    }


    //双指针
    public static ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;// 1,2,3,4,5  2
        ListNode left = dummy;
        ListNode right = dummy;
        while (n + 1 > 0) {
            right = right.next;
            n--;
        }
        while (right != null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}
