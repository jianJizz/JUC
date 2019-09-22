package com.usc.leetcode;
/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

    示例：

    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        //curr的每次都是指向最小的那个值
        while(l1 != null && l2 != null){
            boolean check = l1.val < l2.val;
            // 比较l1,l2的val 让curr指向小的
            if (check){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 == null) ? l2 : l1;  

        return dummy.next;
    }
}