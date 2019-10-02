package com.usc.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {

    //使用优先队列 每次将最小的元素poll出来 用curr指针指向它
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int len = lists.length;
        if (len == 1) return lists[0];
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(len, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });

        for (int i=0; i< len; i++){
            if (lists[i] != null) queue.add(lists[i]);
        }
        while (!queue.isEmpty()){
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) queue.add(curr.next);
        }

        return dummy.next;
    }
}
