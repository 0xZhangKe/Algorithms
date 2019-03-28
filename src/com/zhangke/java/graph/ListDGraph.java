package com.zhangke.java.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 邻接链表（Adjacency List）实现的有向图
 *
 * @param <V>
 */
public class ListDGraph<V> implements DGraph<V> {

    /**
     * 广度优先的迭代器
     */
    private class BFSIterator implements Iterator<V> {
        /**
         * 已访问过的顶点列表
         */
        private List<V> mVisitList = null;
        /**
         * 待访问的顶点队列
         */
        private Queue<V> mVQueue = null;

        /**
         * 构造广度优先迭代器
         */
        public BFSIterator(V root) {
            mVisitList = new LinkedList<V>();
            mVQueue = new LinkedList<V>();

            //将初始节点入队列
            mVQueue.offer(root);
        }

        @Override
        public boolean hasNext() {
            Utils.log("queue size : " + mVQueue.size());
            return mVQueue.size() > 0;
        }

        @Override
        public V next() {
            //1.取队列元素
            V v = mVQueue.poll();

            if (v != null) {
                //2.将此元素的邻接边中对应顶点入队列，这些顶点需要符合以下条件：
                //1)没访问过；
                //2)不在队列中；
                Vertex<V> ve = getVE(v);
                if (ve != null) {
                    List<Edge<Vertex<V>>> list = ve.getEdgeList();
                    for (Edge<Vertex<V>> edge : list) {
                        Vertex<V> dest = edge.getDest();
                        if (!VinList(dest.getValue(), mVisitList.iterator()) &&
                                !VinList(dest.getValue(), mVQueue.iterator())) {
                            mVQueue.offer(dest.getValue());
                            Utils.log("add to queue : " + dest);
                        }
                    }
                }

                //3.将此顶点添加到已访问过的顶点列表中
                mVisitList.add(v);
            }

            //4.返回出队列的元素
            return v;
        }

        @Override
        public void remove() {
            // 暂时不实现
        }

    }

    /**
     * 顶点列表，由于会经常进行插入删除，使用链表队列
     */
    private LinkedList<Vertex<V>> mVEList;

    /**
     * 构造邻接链表有向图
     */
    public ListDGraph() {
        mVEList = new LinkedList<>();
        Utils.log("ListDGraph construct!");
    }

    @Override
    public int add(Vertex<V> v) {
        int index = -1;
        if (v != null) {
            Utils.log("add v: %s", v);
            mVEList.add(v);
            index = mVEList.indexOf(v);
        }
        return index;
    }

    @Override
    public void add(Edge<Vertex<V>> e) {
        if (e != null) {
            Utils.log("add edge: %s", e);
            Vertex<V> ve = getVE(e.getSource().getValue());
            if (ve != null) {
                //若边的起点已经在列表里，则直接将其添加到对应的顶点对象中
                ve.addEdge(e);
            } else {
                //否则提示错误
                Utils.log("Error, can't find v : %s", e.getSource());
            }
        }
    }

    @Override
    public V remove(V v) {
        V ret = null;
        Vertex<V> ve = removeVE(v);
        if (ve != null) {
            ret = ve.getValue();
        }
        removeRelateEdge(v);
        return ret;
    }

    @Override
    public Edge<Vertex<V>> remove(Edge<Vertex<V>> e) {
        Edge<Vertex<V>> ret = null;
        if (e != null) {
            Vertex<V> ve = getVE(e.getDest().getValue());
            if (ve != null) {
                ret = ve.removeEdge(e.getSource());
            }
        }
        return ret;
    }

    @Override
    public Vertex<V> get(int index) {
        Vertex<V> vertex = null;
        if (index >= 0 && index < mVEList.size()) {
            vertex = mVEList.get(index);
            if (vertex != null) {
                Utils.log("get, index : %s, value: %s", index, vertex.getValue());
            }
        }
        return vertex;
    }

    @Override
    public Edge<Vertex<V>> get(int src, int dest) {
        Edge<Vertex<V>> ret = null;
        Vertex<V> s = get(src);
        Vertex<V> d = get(dest);
        if (s != null && d != null) {
            Vertex<V> ve = getVE(s.getValue());
            if (ve != null) {
                ret = ve.getEdge(d);
            }
        }
        return ret;
    }

    @Override
    public Iterator<V> iterator(int type, V root) {
        Iterator<V> ret = null;
        if (type == ITERATOR_TYPE_BFS) {
            //广度优先的迭代器
            ret = new BFSIterator(root);
        } else if (type == ITERATOR_TYPE_DFS) {
            //深度优先的迭代器，暂时未实现
        } else {
            //...
        }
        return ret;
    }

    @Override
    public int get(Vertex<V> v) {
        return mVEList.indexOf(v);
    }

    @Override
    public void convertDAG() {
        // TODO Auto-generated method stub

    }

    @Override
    public int size() {
        return mVEList.size();
    }

    //////////////////////////////私有方法//////////////////////////////

    /**
     * 从顶点对象列表中读取输入顶点对应的对象
     */
    private Vertex<V> getVE(V v) {
        Vertex<V> ret = null;
        if (v != null) {
            for (Vertex<V> ve : mVEList) {
                if (ve.getValue() != null && v.equals(ve.getValue())) {
                    Utils.log("getVE : %s", ve);
                    ret = ve;
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * 从顶点对象列表中删除输入顶点对应的对象
     */
    private Vertex<V> removeVE(V v) {
        Vertex<V> ret = null;
        if (v != null) {
            for (Vertex<V> ve : mVEList) {
                if (ve.getValue() != null && v.equals(ve.getValue())) {
                    Utils.log("removeVE : %s", v);
                    ret = ve;
                    mVEList.remove(ve);
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * 删除以某个点作为重点的边
     */
    private void removeRelateEdge(V v) {
        if (v != null) {
            for (Vertex<V> ve : mVEList) {
                ve.removeEdge(getVE(v));
            }
        }
    }

    /**
     * 判断某个端点是否在某个列表里
     */
    private boolean VinList(V v, Iterator<V> it) {
        boolean ret = false;
        if (v != null && it != null) {
            while (it.hasNext()) {
                V v_temp = it.next();
                if (v_temp != null && v_temp.equals(v)) {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }
}
