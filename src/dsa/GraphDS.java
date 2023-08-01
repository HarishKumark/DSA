/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author hkorada
 */
public class GraphDS {

    static class Edge {

        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

    }

    public static void creatrGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 4, 10));
//        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 4, -1));
        graph[3].add(new Edge(3, 5, -1));

        graph[3].add(new Edge(4, 2, -1));
        graph[3].add(new Edge(4, 3, -1));
        graph[3].add(new Edge(4, 5, -1));

        graph[3].add(new Edge(5, 3, -1));
        graph[3].add(new Edge(5, 4, -1));
        graph[3].add(new Edge(5, 6, -1));

        graph[3].add(new Edge(6, 5, -1));

    }

    public static void main(String[] args) {

        int v = 7;

        ArrayList<Edge> graph[] = new ArrayList[v];

        creatrGraph(graph);
        boolean vis[] = new boolean[v];
        DFS(graph, 0, vis);

//        for (int i = 0; i < v; i++) {
//            if (!vis[i]) {
//                BFS(graph, v, vis, i);
//            }
//        }
        System.out.println("");

//        for (int i = 0; i < graph[2].size(); i++) {
//            Edge e = graph[2].get(i);
//            System.out.println(e.dest + " == " + e.weight);
//        }
    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean vis[]) {

        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                DFS(graph, e.dest, vis);
            }
        }

    }

    public static void BFS(ArrayList<Edge> graph[], int v, boolean vis[], int start) {
        Queue<Integer> q = new java.util.LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        return 0.0;
    }

}
