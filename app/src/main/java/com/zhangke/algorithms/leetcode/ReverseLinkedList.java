package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.data.ListNode;

/**
 * 206. 反转链表:
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * Created by ZhangKe on 2021/3/11.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode parent = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = parent;
            parent = cur;
            cur = next;
        }
        return parent;
    }

    public static void main(String[] args) {
        case1();
        case2();
    }

    private static void case1(){
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        ReverseLinkedList rll = new ReverseLinkedList();
        System.out.println(head.getDesc());
        System.out.println(rll.reverseList(head).getDesc());
    }

    private static void case2(){
        ListNode head = new ListNode(1);
        ReverseLinkedList rll = new ReverseLinkedList();
        System.out.println(head.getDesc());
        System.out.println(rll.reverseList(head).getDesc());
    }
}
