package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.data.ListNode;

/**
 * 141. 环形链表:
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * Created by ZhangKe on 2021/3/8.
 */
public class LinkedListCycle {

    //    public boolean hasCycle(ListNode head) {
//        ListNode t = head;
//        ListNode h = head.getNext() == null ? null : head.getNext().getNext();
//        int pos = -1;
//        while (h != null) {
//            if (h == t) {
//                h = h.getNext();
//                pos++;
//                while (h != t) {
//                    h = h.getNext();
//                    pos++;
//                }
//                break;
//            } else {
//                t = t == null ? null : t.getNext();
//                h = h.getNext() == null ? null : h.getNext().getNext();
//            }
//        }
//        return pos != -1;
//    }
    public boolean hasCycle(ListNode head) {
        ListNode t = head;
        ListNode h = head == null ? null : head.next == null ? null : head.next.next;
        while (h != null) {
            if (h == t) {
                return true;
            } else {
                t = t == null ? null : t.next;
                h = h.next == null ? null : h.next.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        caseOne();
        caseTwo();
        caseThree();
        caseFour();
    }

    private static void caseOne() {
        ListNode tail = new ListNode(-4);
        ListNode zero = new ListNode(0, tail);
        ListNode two = new ListNode(2, zero);
        ListNode head = new ListNode(3, two);
        tail.next = two;
        LinkedListCycle llc = new LinkedListCycle();
        System.out.println(llc.hasCycle(head));
    }

    private static void caseTwo() {
        ListNode tail = new ListNode(2);
        ListNode head = new ListNode(1, tail);
        tail.next = head;
        LinkedListCycle llc = new LinkedListCycle();
        System.out.println(llc.hasCycle(head));
    }

    private static void caseThree() {
        ListNode head = new ListNode(1);
        LinkedListCycle llc = new LinkedListCycle();
        System.out.println(llc.hasCycle(head));
    }

    private static void caseFour() {
        LinkedListCycle llc = new LinkedListCycle();
        System.out.println(llc.hasCycle(null));
    }
}
