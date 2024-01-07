package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.ListNode;

import static com.zhangke.algorithms.Util.printNode;

/**
 * 21. 合并两个有序链表:
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * Created by ZhangKe on 2019/9/11.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        ListNode tmp;
        ListNode curNode = null;
        boolean b;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tmp = l2;
                l2 = l2.getNext();
                b = false;
            } else if (l2 == null) {
                tmp = l1;
                l1 = l1.getNext();
                b = false;
            } else if (l1.getValue() > l2.getValue()) {
                tmp = l2;
                l2 = l2.getNext();
                b = false;
            } else if (l1.getValue() == l2.getValue()) {
                tmp = l1;
                l1 = l1.getNext();
                l2 = l2.getNext();
                b = true;
            } else {
                tmp = l1;
                l1 = l1.getNext();
                b = false;
            }
            if (resultNode == null) {
                resultNode = new ListNode(tmp.getValue());
                curNode = resultNode;
            } else {
                curNode.setNext(new ListNode(tmp.getValue()));
                curNode = curNode.getNext();
            }
            if (b) {
                curNode.setNext(new ListNode(tmp.getValue()));
                curNode = curNode.getNext();
            }
        }
        return resultNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode curNode = node1;
        curNode.setNext(new ListNode(2));
        curNode = curNode.getNext();
        curNode.setNext(new ListNode(4));

        ListNode node2 = new ListNode(1);
        curNode = node2;
        curNode.setNext(new ListNode(3));
        curNode = curNode.getNext();
        curNode.setNext(new ListNode(4));

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        printNode(mergeTwoSortedLists.mergeTwoLists(node1, node2));
    }
}
