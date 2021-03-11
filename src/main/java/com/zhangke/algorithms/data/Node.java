package com.zhangke.algorithms.data;

import java.util.HashSet;
import java.util.Set;

/**
 * 多级双向链表
 * Created by ZhangKe on 2021/3/10.
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    public String getLinearDesc() {
        StringBuilder builder = new StringBuilder();
        Node curNode = this;
        Set<Node> nodeSet = new HashSet<>();
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

    public String getRevertLinearDesc() {
        StringBuilder builder = new StringBuilder();
        Node curNode = getTail(this);
        Set<Node> nodeSet = new HashSet<>();
        while (curNode != null) {
            if (nodeSet.contains(curNode)) {
                break;
            }
            nodeSet.add(curNode);
            builder.append(curNode.val);
            curNode = curNode.prev;
            if (curNode != null) {
                builder.append("->");
            }
        }
        return builder.toString();
    }

    private Node getTail(Node head) {
        Set<Node> nodeSet = new HashSet<>();
        Node curNode = head;
        while (curNode.next != null) {
            if (nodeSet.contains(curNode)) {
                break;
            }
            nodeSet.add(curNode);
            curNode = curNode.next;
        }
        return curNode;
    }

    public String getAllDesc() {
        StringBuilder builder = new StringBuilder();
        Node curNode = this;
        Set<Node> nodeSet = new HashSet<>();
        while (curNode != null) {
            if (nodeSet.contains(curNode)) {
                break;
            }
            nodeSet.add(curNode);
            builder.append("[");
            builder.append(curNode.prev == null ? null : curNode.prev.val);
            builder.append(", ");
            builder.append(curNode.val);
            builder.append(" , ");
            builder.append(curNode.next == null ? null : curNode.next.val);
            builder.append("]");
            curNode = curNode.next;
            if (curNode != null) {
                builder.append("->");
            }
        }
        return builder.toString();
    }
}
