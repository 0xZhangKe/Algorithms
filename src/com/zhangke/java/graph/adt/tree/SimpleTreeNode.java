package com.zhangke.java.graph.adt.tree;

import com.zhangke.java.entity.DirOrFile;

import java.util.*;

/**
 * 数据结构与算法中树的实现
 */
public class SimpleTreeNode<V> {

    private V v;
    private SimpleTreeNode<V> firstChild;
    private SimpleTreeNode<V> nextSibling;

    public SimpleTreeNode(V v) {
        this.v = v;
    }

    public SimpleTreeNode(V v, SimpleTreeNode firstChild, SimpleTreeNode nextSibling) {
        this.v = v;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public SimpleTreeNode<V> getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(SimpleTreeNode<V> firstChild) {
        this.firstChild = firstChild;
    }

    public SimpleTreeNode<V> getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(SimpleTreeNode<V> nextSibling) {
        this.nextSibling = nextSibling;
    }

    public static void main(String[] args) {
        SimpleTreeNode<DirOrFile> usr = getTreeNodeData();
        dfs(usr, 0);
    }

    private static SimpleTreeNode<DirOrFile> getTreeNodeData() {
        SimpleTreeNode<DirOrFile> usr = new SimpleTreeNode<DirOrFile>(new DirOrFile(false, "usr"));
        SimpleTreeNode<DirOrFile> mark = new SimpleTreeNode<>(new DirOrFile(false, "mark"));
        {
            SimpleTreeNode<DirOrFile> book = new SimpleTreeNode<DirOrFile>(new DirOrFile(false, "book"));
            {
                SimpleTreeNode<DirOrFile> ch1r = new SimpleTreeNode<DirOrFile>(new DirOrFile(true, "ch1.r"));
                SimpleTreeNode<DirOrFile> ch2r = new SimpleTreeNode<DirOrFile>(new DirOrFile(true, "ch2.r"));
                SimpleTreeNode<DirOrFile> ch3r = new SimpleTreeNode<DirOrFile>(new DirOrFile(true, "ch3.r"));
                book.setFirstChild(ch1r);
                ch1r.setNextSibling(ch2r);
                ch2r.setNextSibling(ch3r);
            }
            SimpleTreeNode<DirOrFile> course = new SimpleTreeNode<>(new DirOrFile(false, "course"));
            {
                SimpleTreeNode<DirOrFile> cop3530 = new SimpleTreeNode<>(new DirOrFile(false, "COP3530"));
                {
                    SimpleTreeNode<DirOrFile> fall96 = new SimpleTreeNode<>(new DirOrFile(false, "fall96"));
                    {
                        SimpleTreeNode<DirOrFile> sy1r = new SimpleTreeNode<>(new DirOrFile(true, "sy1.r"));
                        fall96.setFirstChild(sy1r);
                    }
                    SimpleTreeNode<DirOrFile> spr97 = new SimpleTreeNode<>(new DirOrFile(false, "spr97"));
                    {
                        SimpleTreeNode<DirOrFile> sy1r = new SimpleTreeNode<>(new DirOrFile(true, "sy1.r"));
                        spr97.setFirstChild(sy1r);
                    }
                    SimpleTreeNode<DirOrFile> sum97 = new SimpleTreeNode<>(new DirOrFile(false, "sum97"));
                    {
                        SimpleTreeNode<DirOrFile> sy1r = new SimpleTreeNode<>(new DirOrFile(true, "sy1.r"));
                        sum97.setFirstChild(sy1r);
                    }
                    fall96.setNextSibling(spr97);
                    spr97.setNextSibling(sum97);
                    cop3530.setFirstChild(fall96);
                }
                course.setFirstChild(cop3530);
            }
            SimpleTreeNode<DirOrFile> junkc = new SimpleTreeNode<DirOrFile>(new DirOrFile(true, "junkc"));
            book.setNextSibling(course);
            course.setNextSibling(junkc);
            mark.setFirstChild(book);
        }
        SimpleTreeNode<DirOrFile> alex = new SimpleTreeNode<DirOrFile>(new DirOrFile(false, "alex"));
        {
            SimpleTreeNode<DirOrFile> junkc = new SimpleTreeNode<DirOrFile>(new DirOrFile(true, "junkc"));
            alex.setFirstChild(junkc);
        }
        SimpleTreeNode<DirOrFile> bill = new SimpleTreeNode<>(new DirOrFile(false, "bill"));
        {
            SimpleTreeNode<DirOrFile> work = new SimpleTreeNode<>(new DirOrFile(false, "work"));
            SimpleTreeNode<DirOrFile> course = new SimpleTreeNode<>(new DirOrFile(false, "course"));
            {
                SimpleTreeNode<DirOrFile> cop3231 = new SimpleTreeNode<>(new DirOrFile(false, "cop3231"));
                {
                    SimpleTreeNode<DirOrFile> fall96 = new SimpleTreeNode<>(new DirOrFile(false, "fall96"));
                    {
                        SimpleTreeNode<DirOrFile> grades = new SimpleTreeNode<>(new DirOrFile(true, "grades"));
                        SimpleTreeNode<DirOrFile> prog1r = new SimpleTreeNode<>(new DirOrFile(false, "prog1.r"));
                        SimpleTreeNode<DirOrFile> prog2r = new SimpleTreeNode<>(new DirOrFile(false, "prog2.r"));
                        grades.setNextSibling(prog1r);
                        prog1r.setNextSibling(prog2r);
                        fall96.setFirstChild(grades);
                    }
                    SimpleTreeNode<DirOrFile> fall97 = new SimpleTreeNode<>(new DirOrFile(false, "fall97"));
                    {
                        SimpleTreeNode<DirOrFile> prog2r = new SimpleTreeNode<>(new DirOrFile(false, "prog2.r"));
                        SimpleTreeNode<DirOrFile> prog1r = new SimpleTreeNode<>(new DirOrFile(false, "prog1.r"));
                        SimpleTreeNode<DirOrFile> grades = new SimpleTreeNode<>(new DirOrFile(true, "grades"));
                        prog2r.setNextSibling(prog1r);
                        prog1r.setNextSibling(grades);
                        fall97.setFirstChild(prog2r);
                    }
                    fall96.setNextSibling(fall97);
                    cop3231.setFirstChild(fall96);
                }
                course.setFirstChild(cop3231);
            }
            work.setNextSibling(course);
            bill.setFirstChild(work);
        }
        mark.setNextSibling(alex);
        alex.setNextSibling(bill);
        usr.setFirstChild(mark);
        return usr;
    }

    private static void dfs(SimpleTreeNode<DirOrFile> d, int depth) {
        if (d != null) {
            printDirOrFile(d.getV(), depth);
            if (d.getFirstChild() != null) {
                dfs(d.getFirstChild(), depth + 1);
            }
            if (d.getNextSibling() != null) {
                dfs(d.getNextSibling(), depth);
            }
        }
    }

    private static void dfsWithLoop(SimpleTreeNode<DirOrFile> d) {
        if (d != null) {
            Stack<Map<SimpleTreeNode<DirOrFile>, Integer>> stack = new Stack<>();
            Map<SimpleTreeNode<DirOrFile>, Integer> root = new HashMap<>();
            root.put(d, 0);
            stack.push(root);
            while (!stack.isEmpty()) {
                Map<SimpleTreeNode<DirOrFile>, Integer> item = stack.pop();
                SimpleTreeNode<DirOrFile> firstKey = item.keySet().iterator().next();
                printDirOrFile(firstKey.getV(), item.get(firstKey));
                if (firstKey.getNextSibling() != null) {
                    Map<SimpleTreeNode<DirOrFile>, Integer> map = new HashMap<>();
                    map.put(firstKey.getNextSibling(), item.get(firstKey));
                    stack.push(map);
                }
                if (firstKey.getFirstChild() != null) {
                    Map<SimpleTreeNode<DirOrFile>, Integer> map = new HashMap<>();
                    map.put(firstKey.getFirstChild(), item.get(firstKey) + 1);
                    stack.push(map);
                }
            }
        }
    }

    private static void printDirOrFile(DirOrFile d, int depth) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            space = space.append("    ");
        }
        System.out.println(String.format("%s%s", space.toString(), d.getName()));
    }
}
