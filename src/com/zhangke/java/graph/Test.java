package com.zhangke.java.graph;

public class Test {

    public static void main(String[] args){
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");
        Vertex<String> F = new Vertex<>("F");
        Vertex<String> G = new Vertex<>("G");

        ListDGraph<String> graph = new ListDGraph<>();
        graph.add(A);
        graph.add(B);
        graph.add(C);
        graph.add(D);
        graph.add(E);
        graph.add(F);
        graph.add(G);

        Edge<Vertex<String>> BA = new Edge<>(B, A);
        Edge<Vertex<String>> BD = new Edge<>(B, D);
        Edge<Vertex<String>> AG = new Edge<>(A, G);
        Edge<Vertex<String>> DE = new Edge<>(D, E);
        Edge<Vertex<String>> DF = new Edge<>(D, F);
        Edge<Vertex<String>> CF = new Edge<>(C, F);
        Edge<Vertex<String>> CG = new Edge<>(C, G);

        graph.add(BA);
        graph.add(BD);
        graph.add(AG);
        graph.add(DE);
        graph.add(DF);
        graph.add(CF);
        graph.add(CG);

        TopologicalSort.sort(graph);
    }
}
