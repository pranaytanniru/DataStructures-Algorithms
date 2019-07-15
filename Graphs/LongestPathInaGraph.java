//link :https://www.hackerrank.com/contests/smart-interviews/challenges/si-longest-path-in-graph
//Program to print the length of LongestPathInaGraph

import java.util.*;
class LongestPathInaGraph {
    public static LinkedList < Integer > [] Graph;
    public static void addEdge(int u, int v) {
        if (u == v) {
            Graph[u].add(v);
            return;
        }
        Graph[u].add(v);
        Graph[v].add(u);
    }
    public static void printArrayList() {
        for (int i = 0; i < Graph.length; i++) {
            System.out.println(Arrays.toString(Graph[i].toArray()));
        }
    }
    public static void initialiseGraph(int n) {
        Graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            Graph[i] = new LinkedList < > ();
        }
    }
    public static void addSomeEdges() {
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);
    }
    public static int BFS(int u) {
        boolean visited[] = new boolean[Graph.length];
        Queue < Integer > que = new LinkedList < > ();
        visited[u] = true;
        que.add(u);
        int ans = 0;
        while (que.size() != 0) {
            int v = que.poll();
            ans = v;
            for (int i = 0; i < Graph[v].size(); i++) {
                if (!visited[Graph[v].get(i)]) {
                    visited[Graph[v].get(i)] = true;
                    que.add(Graph[v].get(i));
                }
            }
        }
        return ans;
    }
    public static int distance(int u, int l) {
        boolean visited[] = new boolean[Graph.length];
        int distance[] = new int[Graph.length];
        Queue < Integer > que = new LinkedList < > ();
        visited[u] = true;
        que.add(u);
        distance[u]=0;
        while (que.size() != 0) {
            int v = que.poll();
            for (int i = 0; i < Graph[v].size(); i++) {
                if (!visited[Graph[v].get(i)]) {
                    visited[Graph[v].get(i)] = true;
                    que.add(Graph[v].get(i));
                    distance[Graph[v].get(i)] = distance[v] + 1;
                }
            }
        }
        return distance[l];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//number of vertices
        int m = sc.nextInt();//number of edges
        initialiseGraph(n);
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(u, v);
        }
        int u = BFS(0);
        int v = BFS(u);
        System.out.println(distance(u, v));
    }
}
