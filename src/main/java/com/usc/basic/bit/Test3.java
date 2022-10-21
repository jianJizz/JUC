package com.usc.basic.bit;

import com.usc.leetcode.ListNode;

/**
 * @author jianjianDuan
 * @date 2022/2/14 11:10 AM
 */
public class Test3 {
    public static void main(String[] args) {
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carray = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carray;
                l1 = l1.next;
                l2 = l2.next;
            }else if (l1 != null && l2 == null) {
                sum = l1.val + carray;
                l1 = l1.next;
            }else if (l1 == null && l2 != null) {
                sum = l2.val + carray;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            carray = sum / 10;
            cur = cur.next;
        }

        if (carray == 1) cur.next = new ListNode(1);

        return dummy.next;
    }
}
