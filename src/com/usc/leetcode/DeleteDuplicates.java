package com.usc.leetcode;

import java.util.List;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next =  new ListNode(1);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(3);
        a.next.next.next.next = new ListNode(3);
        new DeleteDuplicates().deleteDuplicates(a);
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        if (head == null) return dummy.next;
        curr.next = new ListNode(head.val);
        curr = curr.next;
        head = head.next;
        while (head != null){
            if (curr.val != head.val){
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
