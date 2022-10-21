package com.usc.basic;

import com.usc.leetcode.ListNode;

/**
 * @author jianjianDuan
 * @date 2022/10/14 3:15 PM
 */
public class ListNdoeUtils {

    public static ListNode generateListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i=1; i<arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }
}
