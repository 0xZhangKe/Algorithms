package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.leetcode.Common.*;

import static com.zhangke.algorithms.leetcode.Common.printNode;

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
                l2 = l2.next;
                b = false;
            } else if (l2 == null) {
                tmp = l1;
                l1 = l1.next;
                b = false;
            } else if (l1.val > l2.val) {
                tmp = l2;
                l2 = l2.next;
                b = false;
            } else if (l1.val == l2.val) {
                tmp = l1;
                l1 = l1.next;
                l2 = l2.next;
                b = true;
            } else{
                tmp = l1;
                l1 = l1.next;
                b = false;
            }
            if (resultNode == null) {
                resultNode = new ListNode(tmp.val);
                curNode = resultNode;
            } else {
                curNode.next = new ListNode(tmp.val);
                curNode = curNode.next;
            }
            if(b){
                curNode.next = new ListNode(tmp.val);
                curNode = curNode.next;
            }
        }
        return resultNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode curNode = node1;
        curNode.next = new ListNode(2);
        curNode = curNode.next;
        curNode.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        curNode = node2;
        curNode.next = new ListNode(3);
        curNode = curNode.next;
        curNode.next = new ListNode(4);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        printNode(mergeTwoSortedLists.mergeTwoLists(node1, node2));
    }
}
