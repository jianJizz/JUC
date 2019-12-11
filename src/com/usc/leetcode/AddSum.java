package com.usc.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * CTRL ALT F6
 */
public class AddSum {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
       l2.next.next = new ListNode(9);

        ListNode res = new AddSum().addSum(l1, l2);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
        System.out.println(res.next.next.next.val);
    }

    public ListNode addSum(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0; // 进位
        ListNode curr = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null || p2 != null) {
            int sum = 0;
            if (p1 != null && p2 != null) {
                sum = p1.val + p2.val + carry;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                carry = sum / 10;
                p1 = p1.next;
                p2 = p2.next;
                continue;
            }

            // p1!=null && p2=null
            if (p1 != null) {
                sum = p1.val + carry;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                carry = sum / 10;
                p1 = p1.next;
                continue;
            }

            // p2!=null p1 == null
            if (p2 != null) {
                sum = p2.val + carry;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                carry = sum / 10;
                p2 = p2.next;
            }
        }

        if (carry == 1) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}

