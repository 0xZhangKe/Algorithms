package com.zhangke.algorithms.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ZhangKe on 2019/10/31.
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public String getDesc() {
        StringBuilder builder = new StringBuilder();
        ListNode curNode = this;
        Set<ListNode> nodeSet = new HashSet<>();
        while (curNode != null) {
            if (nodeSet.contains(curNode)) {
                break;
            }
            nodeSet.add(curNode);
            builder.append(curNode.val);
            curNode = curNode.next;
            if (curNode != null) {
                builder.append("->");
            }
        }
        return builder.toString();
    }
}
