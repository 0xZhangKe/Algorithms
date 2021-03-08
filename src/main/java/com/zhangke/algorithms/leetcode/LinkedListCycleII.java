package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.data.ListNode;
import org.jetbrains.annotations.Contract;

/**
 * 142. 环形链表 II:
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * Created by ZhangKe on 2021/3/8.
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = nextNextNode(slow);
        ListNode cycleHead = null;
        while (slow != null) {
            if (fast == slow) {
                slow = slow.next;
                ListNode ptr = head.next;
                while (slow != ptr) {
                    slow = slow.next;
                    ptr = ptr.next;
                }
                cycleHead = ptr;
                break;
            } else {
                slow = slow.next;
                fast = nextNextNode(fast);
            }
        }
        return cycleHead;
    }

    @Contract(value = "null -> null", pure = true)
    private ListNode nextNextNode(ListNode node) {
        return node == null ? null : node.next == null ? null : node.next.next;
    }

    public static void main(String[] args) {
        caseOne();
        caseTwo();
//        caseThree();
//        caseFour();
    }

    private static void caseOne() {
        ListNode tail = new ListNode(-4);
        ListNode zero = new ListNode(0, tail);
        ListNode two = new ListNode(2, zero);
        ListNode head = new ListNode(3, two);
        tail.next = two;
        LinkedListCycleII llc = new LinkedListCycleII();
        System.out.println(llc.detectCycle(head).getDesc());
    }

    private static void caseTwo() {
        ListNode tail = new ListNode(2);
        ListNode head = new ListNode(1, tail);
        tail.next = head;
        LinkedListCycleII llc = new LinkedListCycleII();
        System.out.println(llc.detectCycle(head).getDesc());
    }

    private static void caseThree() {
        ListNode head = new ListNode(1);
        LinkedListCycleII llc = new LinkedListCycleII();
        ListNode result = llc.detectCycle(head);
        if (result != null) {
            System.out.println(result.getDesc());
        }
    }

    private static void caseFour() {
        LinkedListCycleII llc = new LinkedListCycleII();
        ListNode result = llc.detectCycle(null);
        if (result != null) {
            System.out.println(result.getDesc());
        }
    }
}
