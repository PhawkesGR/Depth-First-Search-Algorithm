
package javaapplication9;

import java.util.ArrayList;

public class DepthFirst {

    static class Edge {

        public Node nodeFrom;
        public Node nodeTo;
        public int cost;

        public Edge(Node nodeFrom, Node nodeTo, int cost) {
            this.nodeFrom = nodeFrom;
            this.nodeTo = nodeTo;
            this.cost = cost;
        }
    }

    static class Node {

        public String name;
        public int hValue;
        public ArrayList<Edge> edges = new ArrayList<>();
        public Node bestChild;

        public Node(String name, int hValue) {
            this.name = name;
            this.hValue = hValue;
        }

        public void addEdge(Node to, int cost) {
            Edge edge = new Edge(this, to, cost);
            this.edges.add(edge);
        }
    }

    public static boolean DFS(Node start, boolean found) {
        for (Edge e : start.edges) {
            Node nextToSearch = e.nodeTo;
            if (!(nextToSearch.hValue == 0)) {
                System.out.print(nextToSearch.name + "-->");
                found = DFS(nextToSearch, found);
                if (found) {
                    return true;
                }
            } else {
                System.out.print(nextToSearch.name);
                return true;
            }
        }
        return false;
    }

    static class Graph {
        
        public Node graphGenerator() {
            Node S = new Node("S", 4);
            Node A = new Node("A", 2);
            Node B = new Node("B", 3);
            Node C = new Node("C", 4);
            Node D = new Node("D", 5);
            Node E = new Node("E", 6);
            Node F = new Node("F", 4);
            Node H = new Node("H", 3);
            Node I = new Node("I", 2);
            Node J = new Node("J", 1);
            Node G = new Node("G", 0);
            Node K = new Node("K", 5);
            Node L = new Node("L", 6);

            S.addEdge(A, 2);
            A.addEdge(B, 2);
            B.addEdge(C, 2);
            C.addEdge(D, 2);
            D.addEdge(E, 1);
            D.addEdge(G, 5);
            B.addEdge(G, 3);
            S.addEdge(K, 2);
            K.addEdge(L, 1);
            S.addEdge(F, 1);
            F.addEdge(H, 1);
            H.addEdge(I, 1);
            I.addEdge(J, 1);
            J.addEdge(G, 1);

            return S;
        }
    }

    public static void main(String[] args) {
        Graph graphGen = new Graph();
        Node start = graphGen.graphGenerator();
        DFS(start, false);
    }

}
