package com.zhangke.algorithms.leetcode;

/**
 * 86. 分隔链表:
 * https://leetcode-cn.com/problems/partition-list/
 * Created by ZhangKe on 2021/3/4.
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode curParent = null;
        ListNode newHead = null;
        while (cur != null) {
            if (cur.val >= x) {
                ListNode tmpParent = cur;
                ListNode tmpCur = cur.next;
                while (tmpCur != null && tmpCur.val >= x) {
                    tmpParent = tmpCur;
                    tmpCur = tmpCur.next;
                }
                if (tmpCur == null) {
                    if (newHead == null) newHead = head;
                    break;
                }
                tmpParent.next = tmpCur.next;
                if (curParent != null) {
                    curParent.next = tmpCur;
                }
                tmpCur.next = cur;
                cur = tmpCur;
            }
            curParent = cur;
            if (newHead == null) newHead = cur;
            cur = cur.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode two = new ListNode(2);
        ListNode five = new ListNode(5, two);
        ListNode two2 = new ListNode(2, five);
        ListNode three = new ListNode(3, two2);
        ListNode four = new ListNode(4, three);
        ListNode head = new ListNode(7, four);
//        ListNode head = new ListNode(1);
        PartitionList pl = new PartitionList();
        System.out.println("input:" + head.print());
        System.out.println("output:" + pl.partition(head, 3).print());
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String print() {
            StringBuilder sb = new StringBuilder();
            ListNode curNode = this;
            while (curNode != null) {
                sb.append(curNode.val);
                curNode = curNode.next;
                if (curNode != null) {
                    sb.append("->");
                }
            }
            return sb.toString();
        }
    }
}