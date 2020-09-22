package com.zhangke.algorithms.leetcode;

import static com.zhangke.algorithms.leetcode.Util.buildListNode;
import static com.zhangke.algorithms.leetcode.Util.printNode;

/**
 * 19. 删除链表的倒数第N个节点:
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * Created by ZhangKe on 2019/9/9.
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode curNode = head;
        while (curNode != null) {
            size++;
            curNode = curNode.getNext();
        }
        int target = size - n - 1;
        if (target < 0) {
            return head.getNext();
        } else {
            delete(head, 0, target);
            return head;
        }
    }

    private void delete(ListNode head, int position, int target) {
        if (position == target) {
            if (head.getNext() != null) {
                head.setNext(head.getNext().getNext());
            }
        } else {
            delete(head.getNext(), position + 1, target);
        }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList opt = new RemoveNthNodeFromEndOfList();
        ListNode node = new ListNode(1);
        buildListNode(node, 1, 5);
        ListNode result = opt.removeNthFromEnd(node, 2);
        printNode(result);
    }
}
