package com.zhangke.algorithms.leetcode;

/**
 * 19. 删除链表的倒数第N个节点:
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * Created by ZhangKe on 2019/9/9.
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode curNode = head;
        while (curNode != null) {
            size++;
            curNode = curNode.next;
        }
        int target = size - n - 1;
        if (target < 0) {
            return head.next;
        } else {
            delete(head, 0, target);
            return head;
        }
    }

    private void delete(ListNode head, int position, int target) {
        if (position == target) {
            if (head.next != null) {
                head.next = head.next.next;
            }
        } else {
            delete(head.next, position + 1, target);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private void buildNode(ListNode node, int value, int end) {
        if (value >= end) {
            return;
        }
        node.val = value;
        node.next = new ListNode(value + 1);
        buildNode(node.next, value + 1, end);
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList opt = new RemoveNthNodeFromEndOfList();
        ListNode node = new ListNode(1);
        opt.buildNode(node, 1, 5);

        ListNode result = opt.removeNthFromEnd(node, 2);

        StringBuilder builder = new StringBuilder();
        ListNode curNode = result;
        while (curNode != null) {
            builder.append(curNode.val);
            builder.append("->");
            curNode = curNode.next;
        }
        System.out.println(builder.substring(0, builder.length() - 2));
    }
}
