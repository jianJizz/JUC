package com.usc.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class AddSum{


    public ListNode addSum(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        int carry = 0; //进位
        ListNode curr = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null){
            if (p1!=null){
                // TODO: 看b站leetcode视频 两个月时间刷题
                res.val = p1.val+ p2.val;
            }
        }

        return res;
    }
}


class ListNode{
    int val;
    ListNode next;
    ListNode(int val){ this.val = val; }
}