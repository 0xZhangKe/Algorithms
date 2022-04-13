package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.ListNode;
import com.zhangke.algorithms.Util;

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
            if (cur.getValue() >= x) {
                ListNode tmpParent = cur;
                ListNode tmpCur = cur.getNext();
                while (tmpCur != null && tmpCur.getValue() >= x) {
                    tmpParent = tmpCur;
                    tmpCur = tmpCur.getNext();
                }
                if (tmpCur == null) {
                    if (newHead == null) newHead = head;
                    break;
                }
                tmpParent.setNext(tmpCur.getNext());
                if (curParent != null) {
                    curParent.setNext(tmpCur);
                }
                tmpCur.setNext(cur);
                cur = tmpCur;
            }
            curParent = cur;
            if (newHead == null) newHead = cur;
            cur = cur.getNext();
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
        PartitionList pl = new PartitionList();
        Util.printNode(head);
        Util.printNode(pl.partition(head, 3));
    }
}