package com.usc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RotateRight {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new RotateRight().rotateRight(head, 2);
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int n = 1;
        ListNode cur = head, tail = null;
        while(cur.next != null){
            n++;
            cur = cur.next;
        }

        // 形成闭环
        cur.next = head;
        tail = cur;

        // 计算循环次数
        int loop = n - (k % n);
        for(int i=0; i<loop; i++){
            cur = cur.next;
            tail = tail.next;
        }
        tail.next = null;

        return cur;
    }
}
