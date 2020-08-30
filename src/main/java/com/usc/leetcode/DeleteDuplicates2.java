package com.usc.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates2 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next =  new ListNode(1);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(2);
       // a.next.next.next.next = new ListNode(3);
      //  a.next.next.next.next.next = new ListNode(4);
       // a.next.next.next.next.next.next = new ListNode(5);
        new DeleteDuplicates2().deleteDuplicates(a);
    }

    //思路 对每个元素对比前后是否相等如果不等就加入到curr中 分别处理第一个元素pre=null和最后一个元素 next=null
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode p = head;
        // 1 1 2 2
        if (p.next == null) return head;
        if (p.val == p.next.val) {
            // 1  1  2  2
            //   pre p
            //p向后移动两位 pre向后移动一位
            pre = p.next;
            p = p.next.next;

        }else{
            curr.next = new ListNode(p.val);
            curr = curr.next;
            // 1  2  3
            // pre p
            //p向后移动一位pre向后移动一位
            pre = p;
            p = p.next;
        }
        //至此第一个元素处理完毕
        while (p != null){
            ListNode next = p.next;
            //处理中间的元素和最后一个元素
            if (pre.val != p.val && (next == null ? true : p.val != next.val)){
                curr.next = new ListNode(p.val);
                curr = curr.next;
            }
            pre = pre.next;
            p = p.next;
        }

        return dummy.next;
    }
}
