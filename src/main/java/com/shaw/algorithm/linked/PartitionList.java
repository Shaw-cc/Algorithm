package com.shaw.algorithm.linked;

import com.shaw.algorithm.util.ListNode;

/**
 * <a href = 'https://leetcode-cn.com/problems/partition-list-lcci/' >分割链表</a >
 *
 * @Author: Shaw
 * @Date: 2022/4/6 21:26
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1, null);
        ListNode b = new ListNode(4, null);
        ListNode c = new ListNode(3, null);
        ListNode d = new ListNode(2, null);
        ListNode e = new ListNode(5, null);
        ListNode f = new ListNode(2, null);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(partition(a, 3));
    }

    // 双指针
    public static ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode p1 = left;
        ListNode right = new ListNode(0);
        ListNode p2 = right;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = p2.next;
        return p1.next;
    }
}
