package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.data.ListNode;

/**
 * 61. 旋转链表:
 * https://leetcode-cn.com/problems/rotate-list/
 * Created by ZhangKe on 2021/3/11.
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        int linkedListLen = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            linkedListLen++;
        }
        if (linkedListLen <= 1) return head;
        int step = linkedListLen - k % linkedListLen - 1;
        if (step == linkedListLen - 1) return head;
        ListNode newTail = head;
        for (int i = 0; i < step; i++) {
            newTail = newTail.next;
        }
        cur = newTail;
        while (cur.next != null) cur = cur.next;
        ListNode newHead = newTail.next;
        newTail.next = null;
        cur.next = head;
        return newHead;
    }

    public static void main(String[] args) {
//        case1();
//        case2();
//        case3();
//        case4();
        case5();
    }

    private static void case1() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        RotateList rl = new RotateList();
        System.out.println(head.getDesc());
        System.out.println(rl.rotateRight(head, 2).getDesc());
    }

    private static void case2() {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(0, node1);
        RotateList rl = new RotateList();
        System.out.println(head.getDesc());
        System.out.println(rl.rotateRight(head, 4).getDesc());
    }

    private static void case3() {
        ListNode head = new ListNode(0);
        RotateList rl = new RotateList();
        System.out.println(head.getDesc());
        System.out.println(rl.rotateRight(head, 4).getDesc());
    }

    private static void case4() {
        ListNode node2 = new ListNode(2);
        ListNode head = new ListNode(1, node2);
        RotateList rl = new RotateList();
        System.out.println(head.getDesc());
        System.out.println(rl.rotateRight(head, 0).getDesc());
    }

    private static void case5() {
        ListNode node2 = new ListNode(2);
        ListNode head = new ListNode(1, node2);
        RotateList rl = new RotateList();
        System.out.println(head.getDesc());
        System.out.println(rl.rotateRight(head, 2).getDesc());
    }
}
