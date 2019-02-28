package com.zhangke.java.graph.tree;

import com.zhangke.java.entity.DirOrFile;

import java.util.*;

/**
 * 大部分情况下树的实现
 */
public class TreeNode<V> {

    private V value;
    private List<TreeNode<V>> childList;

    public TreeNode(V value) {
        this.value = value;
    }

    public TreeNode(V value, List<TreeNode<V>> childList) {
        this.value = value;
        this.childList = childList;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public List<TreeNode<V>> getChildList() {
        return childList;
    }

    public void setChildList(List<TreeNode<V>> childList) {
        this.childList = childList;
    }

    public static void main(String[] args) {
        TreeNode<DirOrFile> root = getTreeData();
        bfs(root.getChildList(), 1);
    }

    /**
     * 深度优先搜索递归实现
     */
    public static void dfs(TreeNode<DirOrFile> tree, int depth) {
        if (tree != null) {
            printDirOrFile(tree.getValue(), depth);
            if (tree.getChildList() != null && !tree.getChildList().isEmpty()) {
                for (TreeNode<DirOrFile> item : tree.getChildList()) {
                    dfs(item, depth + 1);
                }
            }
        }
    }

    /**
     * 深度优先搜索非递归实现
     */
    public static void dfsNotRecursive(TreeNode<DirOrFile> tree) {
        if (tree != null) {
            Stack<Map<TreeNode<DirOrFile>, Integer>> stack = new Stack<>();
            Map<TreeNode<DirOrFile>, Integer> root = new HashMap<>();
            root.put(tree, 0);
            stack.push(root);
            while (!stack.isEmpty()) {
                Map<TreeNode<DirOrFile>, Integer> item = stack.pop();
                TreeNode<DirOrFile> node = item.keySet().iterator().next();
                int depth = item.get(node);
                printDirOrFile(node.getValue(), depth);
                if (node.getChildList() != null && !node.getChildList().isEmpty()) {
                    for (TreeNode<DirOrFile> treeNode : node.getChildList()) {
                        Map<TreeNode<DirOrFile>, Integer> map = new HashMap<>();
                        map.put(treeNode, depth + 1);
                        stack.push(map);
                    }
                }
            }
        }
    }

    /**
     * 广度优先搜索算法递归实现
     */
    public static void bfs(List<TreeNode<DirOrFile>> childs, int depth) {
        List<TreeNode<DirOrFile>> oneTempChilds, allTempChilds = new ArrayList<>();
        for (TreeNode<DirOrFile> child: childs) {
            printDirOrFile(child.getValue(), depth);
            oneTempChilds = child.getChildList();
            if (oneTempChilds != null && oneTempChilds.size() > 0) {
                allTempChilds.addAll(oneTempChilds);
            }
        }
        if (allTempChilds.size() > 0)  {
            bfs(allTempChilds, depth + 1); // 递归调用
        }
    }

    /**
     * 广度优先搜索算法非递归实现
     */
    public static void bfsNotRecursive(TreeNode<DirOrFile> tree) {
        if (tree != null) {
            Queue<Map<TreeNode<DirOrFile>, Integer>> queue = new ArrayDeque<>();
            Map<TreeNode<DirOrFile>, Integer> root = new HashMap<>();
            root.put(tree, 0);
            queue.offer(root);
            while (!queue.isEmpty()) {
                Map<TreeNode<DirOrFile>, Integer> itemMap = queue.poll();
                TreeNode<DirOrFile> itemTreeNode = itemMap.keySet().iterator().next();
                int depth = itemMap.get(itemTreeNode);
                printDirOrFile(itemTreeNode.getValue(), depth);
                if (itemTreeNode.getChildList() != null &&
                        !itemTreeNode.getChildList().isEmpty()) {
                    for (TreeNode<DirOrFile> child : itemTreeNode.getChildList()) {
                        Map<TreeNode<DirOrFile>, Integer> map = new HashMap<>();
                        map.put(child, depth + 1);
                        queue.offer(map);
                    }
                }
            }
        }
    }

    private static TreeNode<DirOrFile> getTreeData() {
        TreeNode<DirOrFile> usr = new TreeNode<>(new DirOrFile("usr"));
        {
            TreeNode<DirOrFile> mark = new TreeNode<>(new DirOrFile("mark"));
            {
                TreeNode<DirOrFile> book = new TreeNode<>(new DirOrFile("book"));
                {
                    TreeNode<DirOrFile> ch1r = new TreeNode<>(new DirOrFile("ch1.r"));
                    TreeNode<DirOrFile> ch2r = new TreeNode<>(new DirOrFile("ch2.r"));
                    TreeNode<DirOrFile> ch3r = new TreeNode<>(new DirOrFile("ch3.r"));
                    ArrayList<TreeNode<DirOrFile>> bookChildList = new ArrayList<>();
                    bookChildList.add(ch1r);
                    bookChildList.add(ch2r);
                    bookChildList.add(ch3r);
                    book.setChildList(bookChildList);
                }
                TreeNode<DirOrFile> course = new TreeNode<>(new DirOrFile("course"));
                {
                    TreeNode<DirOrFile> cop3530 = new TreeNode<>(new DirOrFile("cop3530"));
                    {
                        TreeNode<DirOrFile> fall96 = new TreeNode<>(new DirOrFile("fall96"));
                        {
                            TreeNode<DirOrFile> sylr = new TreeNode<>(new DirOrFile("syl.r"));
                            fall96.setChildList(Collections.singletonList(sylr));
                        }
                        TreeNode<DirOrFile> spr97 = new TreeNode<>(new DirOrFile("spr97"));
                        {
                            TreeNode<DirOrFile> sylr = new TreeNode<>(new DirOrFile("syl.r"));
                            spr97.setChildList(Collections.singletonList(sylr));
                        }
                        TreeNode<DirOrFile> sum97 = new TreeNode<>(new DirOrFile("sum97"));
                        {
                            TreeNode<DirOrFile> sylr = new TreeNode<>(new DirOrFile("syl.r"));
                            sum97.setChildList(Collections.singletonList(sylr));
                        }
                        ArrayList<TreeNode<DirOrFile>> cop3530ChildList = new ArrayList<>();
                        cop3530ChildList.add(fall96);
                        cop3530ChildList.add(spr97);
                        cop3530ChildList.add(sum97);
                        cop3530.setChildList(cop3530ChildList);
                    }
                    ArrayList<TreeNode<DirOrFile>> courseChildList = new ArrayList<>();
                    courseChildList.add(cop3530);
                    course.setChildList(courseChildList);
                }
                TreeNode<DirOrFile> junkc = new TreeNode<>(new DirOrFile("junk.c"));
                ArrayList<TreeNode<DirOrFile>> markChildList = new ArrayList<>();
                markChildList.add(book);
                markChildList.add(course);
                markChildList.add(junkc);
                mark.setChildList(markChildList);
            }
            TreeNode<DirOrFile> alex = new TreeNode<>(new DirOrFile("alex"));
            {
                TreeNode<DirOrFile> junkc = new TreeNode<>(new DirOrFile("junk.c"));
                alex.setChildList(Collections.singletonList(junkc));
            }
            TreeNode<DirOrFile> bill = new TreeNode<>(new DirOrFile("bill"));
            {
                TreeNode<DirOrFile> work = new TreeNode<>(new DirOrFile("work"));
                TreeNode<DirOrFile> course = new TreeNode<>(new DirOrFile("course"));
                {
                    TreeNode<DirOrFile> cop3212 = new TreeNode<>(new DirOrFile("cop3212"));
                    {
                        TreeNode<DirOrFile> fall96 = new TreeNode<>(new DirOrFile("fall96"));
                        {
                            TreeNode<DirOrFile> grades = new TreeNode<>(new DirOrFile("grades"));
                            TreeNode<DirOrFile> prog1r = new TreeNode<>(new DirOrFile("prog1.r"));
                            TreeNode<DirOrFile> prog2r = new TreeNode<>(new DirOrFile("prog2.r"));
                            ArrayList<TreeNode<DirOrFile>> fall96ChildList = new ArrayList<>();
                            fall96ChildList.add(grades);
                            fall96ChildList.add(prog1r);
                            fall96ChildList.add(prog2r);
                            fall96.setChildList(fall96ChildList);
                        }
                        TreeNode<DirOrFile> fall97 = new TreeNode<>(new DirOrFile("fall97"));
                        {
                            TreeNode<DirOrFile> prog2r = new TreeNode<>(new DirOrFile("prog2.r"));
                            TreeNode<DirOrFile> prog1r = new TreeNode<>(new DirOrFile("prog1.r"));
                            TreeNode<DirOrFile> grades = new TreeNode<>(new DirOrFile("grades"));
                            ArrayList<TreeNode<DirOrFile>> fall97ChildList = new ArrayList<>();
                            fall97ChildList.add(prog2r);
                            fall97ChildList.add(prog1r);
                            fall97ChildList.add(grades);
                            fall97.setChildList(fall97ChildList);
                        }
                        ArrayList<TreeNode<DirOrFile>> cop3212ChildList = new ArrayList<>();
                        cop3212ChildList.add(fall96);
                        cop3212ChildList.add(fall97);
                        cop3212.setChildList(cop3212ChildList);
                    }
                    course.setChildList(Collections.singletonList(cop3212));
                }
                ArrayList<TreeNode<DirOrFile>> billChildList = new ArrayList<>();
                billChildList.add(work);
                billChildList.add(course);
                bill.setChildList(billChildList);

            }
            ArrayList<TreeNode<DirOrFile>> rootChildList = new ArrayList<>();
            rootChildList.add(mark);
            rootChildList.add(alex);
            rootChildList.add(bill);
            usr.setChildList(rootChildList);
        }
        return usr;
    }

    private static void printDirOrFile(DirOrFile d, int depth) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            space = space.append("    ");
        }
        System.out.println(String.format("%s%s", space.toString(), d.getName()));
    }
}
