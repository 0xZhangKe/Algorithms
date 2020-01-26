package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.data.ListNode;

import java.util.Stack;

/**
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * Created by ZhangKe on 2019/11/12.
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode newHead = null;//返回链表的 head
        boolean isFirst = true;//当前是否是首次循环
        ListNode curHead = head;//本次循环的 head
        ListNode lastFoot = null;//上次循环的 foot
        while (true) {
            Stack<ListNode> stack = new Stack<>();
            int position = 0;
            ListNode curNode = curHead;
            while (curNode != null && position < k) {
                stack.push(curNode);
                if(position == k - 1){
                    curHead = curNode.next;
                }
                curNode = curNode.next;
                position++;
            }
            if (position < k) {
                //当前循环不足 k 个，不反转
                if (lastFoot != null) {
                    lastFoot.next = curHead;
                }
                if(isFirst){
                    newHead = head;
                }
                break;
            }
            if (lastFoot != null) {
                lastFoot.next = stack.peek();
            }
            if (isFirst) {
                newHead = stack.peek();
                isFirst = false;
            }
            ListNode lastNode = stack.pop();
            while (!stack.isEmpty()) {
                curNode = stack.pop();
                lastNode.next = curNode;
                curNode.next = null;
                lastNode = curNode;
            }
            lastFoot = lastNode;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup reverse = new ReverseNodesInKGroup();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Util.printNode(reverse.reverseKGroup(node5, 6));
    }
}
