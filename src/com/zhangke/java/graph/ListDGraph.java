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
     * 顶点对象，其中有对应的顶点以及从以此顶点为起点的边
     */
    private class VE {
        /**
         * 此顶点
         */
        private V v;
        /**
         * 以此顶点为起点的边的集合，是一个列表，列表的每一项是一条边
         */
        private List<Edge<V>> mEdgeList;

        /**
         * 构造一个新的顶点对象
         */
        public VE(V v) {
            this.v = v;
            this.mEdgeList = new LinkedList<Edge<V>>();
            Utils.log("VE construct : %s", v);
        }

        @Override
        public String toString() {
            return String.format("v : %s , list len : %s",
                    v, mEdgeList.size());
        }

        /**
         * 将一条边添加到边集合中
         */
        public void addEdge(Edge<V> e) {
            Utils.log("add edge : %s", e);
            if (getEdge(e.getDest()) == null) {
                mEdgeList.add(e);
            } else {
                Utils.log("edge exist : %s", e);
            }
        }

        /**
         * 读取某条边
         */
        public Edge<V> getEdge(V dest) {
            Edge<V> ret = null;
            if (dest != null) {
                for (Edge<V> edge : mEdgeList) {
                    if (edge.getDest() != null &&
                            dest.equals(edge.getDest())) {
                        Utils.log("get edge : %s", edge);
                        ret = edge;
                        break;
                    }
                }
            }
            return ret;
        }

        /**
         * 删除某条边
         */
        public Edge<V> removeEdge(V dest) {
            Edge<V> ret = null;
            if (dest != null) {
                for (Edge<V> edge : mEdgeList) {
                    if (edge.getDest() != null &&
                            dest.equals(edge.getDest())) {
                        Utils.log("remove edge : %s", edge);
                        ret = edge;
                        mEdgeList.remove(edge);
                        break;
                    }
                }
            }
            return ret;
        }
    }


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
         *
         * @param root
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
            if (mVQueue.size() > 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public V next() {
            //1.取队列元素
            V v = mVQueue.poll();

            if (v != null) {
                //2.将此元素的邻接边中对应顶点入队列，这些顶点需要符合以下条件：
                //1)没访问过；
                //2)不在队列中；
                VE ve = getVE(v);
                if (ve != null) {
                    List<Edge<V>> list = ve.mEdgeList;
                    for (Edge<V> edge : list) {
                        V dest = edge.getDest();
                        if (!VinList(dest, mVisitList.iterator()) &&
                                !VinList(dest, mVQueue.iterator())) {
                            mVQueue.offer(dest);
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
    private LinkedList<VE> mVEList;

    /**
     * 构造邻接链表有向图
     */
    public ListDGraph() {
        mVEList = new LinkedList<VE>();
        Utils.log("ListDGraph construct!");
    }

    @Override
    public int add(V v) {
        int index = -1;
        if (v != null) {
            Utils.log("add v: %s", v);
            VE list = new VE(v);
            mVEList.add(list);
            index = mVEList.indexOf(list);
        }
        return index;
    }

    @Override
    public void add(Edge<V> e) {
        if (e != null) {
            Utils.log("add edge: %s", e);
            VE ve = getVE(e.getSource());
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

        VE ve = removeVE(v);
        if (ve != null) {
            ret = ve.v;
        }

        removeRelateEdge(v);

        return ret;
    }

    @Override
    public Edge<V> remove(Edge<V> e) {
        Edge<V> ret = null;

        if (e != null) {
            VE ve = getVE(e.getSource());
            if (ve != null) {
                ret = ve.removeEdge(e.getDest());
            }
        }

        return ret;
    }

    @Override
    public V get(int index) {
        V ret = null;
        if (index >= 0 && index < mVEList.size()) {
            VE ve = mVEList.get(index);
            if (ve != null) {
                ret = ve.v;
                Utils.log("get , index : %s , v : %s", index, ret);
            }
        }
        return ret;
    }

    @Override
    public Edge<V> get(int src, int dest) {
        Edge<V> ret = null;
        V s = get(src);
        V d = get(dest);
        if (s != null && d != null) {
            VE ve = getVE(s);
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
    public void convertDAG() {
        // TODO Auto-generated method stub

    }

    //////////////////////////////私有方法//////////////////////////////

    /**
     * 从顶点对象列表中读取输入顶点对应的对象
     */
    private VE getVE(V v) {
        VE ret = null;
        if (v != null) {
            for (VE ve : mVEList) {
                if (ve.v != null && v.equals(ve.v)) {
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
    private VE removeVE(V v) {
        VE ret = null;
        if (v != null) {
            for (VE ve : mVEList) {
                if (ve.v != null && v.equals(ve.v)) {
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
            for (VE ve : mVEList) {
                ve.removeEdge(v);
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
