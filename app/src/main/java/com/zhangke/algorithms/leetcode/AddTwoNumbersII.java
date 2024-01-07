package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.data.ListNode;

import java.util.Stack;

/**
 * 445. 两数相加 II:
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * Created by ZhangKe on 2021/3/11.
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        ListNode cur = l1;
        while (cur != null) {
            first.push(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            second.push(cur.val);
            cur = cur.next;
        }
        boolean needEnter = false;
        ListNode next = null;
        while (!first.isEmpty() || !second.isEmpty()) {
            int firstVal = first.isEmpty() ? 0 : first.pop();
            int secondVal = second.isEmpty() ? 0 : second.pop();
            int summary = firstVal + secondVal;
            if (needEnter) summary++;
            if (summary >= 10) {
                needEnter = true;
                summary -= 10;
            } else {
                needEnter = false;
            }
            ListNode node = new ListNode(summary);
            if (next != null) {
                node.next = next;
            }
            next = node;
        }
        if (needEnter) {
            return new ListNode(1, next);
        } else {
            return next;
        }
    }

    public static void main(String[] args) {
        case1();
    }

    private static void case1() {
        ListNode first3 = new ListNode(3);
        ListNode first4 = new ListNode(4, first3);
        ListNode first2 = new ListNode(2, first4);
        ListNode first7 = new ListNode(7, first2);

        ListNode second4 = new ListNode(4);
        ListNode second6 = new ListNode(6, second4);
        ListNode second5 = new ListNode(5, second6);

        System.out.println(first7.getDesc());
        System.out.println(second5.getDesc());

        AddTwoNumbersII at = new AddTwoNumbersII();
        System.out.println(at.addTwoNumbers(first7, second5).getDesc());
    }
}
