package com.shaw.algorithm.linked;

import com.shaw.algorithm.util.ListNode;

import java.util.TreeSet;

/**
 * <a href='https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/'>1721. 交换链表中的节点</a>
 *
 * @Author: Shaw
 * @Date: 2022/4/3 22:58
 */
public class SwappingNodes {
    public static void main(String[] args) {
        //String[] emails = {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};

        System.out.println(numUniqueEmails(emails));
    }

    // 双指针
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode node = head;
        // 索引从1开始
        ListNode next = new ListNode(-1, head);
        for (int i = 0; i < k; i++) {
            next = next.next;
        }
        // 找到第k位节点
        ListNode swap = next;
        // 遍历到链表结尾
        while (next.next != null) {
            node = node.next;
            next = next.next;
        }
        // swap
        int temp = swap.val;
        swap.val = node.val;
        node.val = temp;
        return head;
    }

    public static int numUniqueEmails(String[] emails) {
        TreeSet<String> set = new TreeSet<>();
        for (String email : emails) {
            String l = email.substring(0, email.indexOf("@"));
            String r = email.substring(email.indexOf("@"));
            if (l.contains("+")) {
                l = l.substring(0, l.indexOf("+"));
            }
            l = l.replaceAll("\\.", "");
            set.add(l + r);
        }
        System.out.println(set);
        return set.size();
    }
}
