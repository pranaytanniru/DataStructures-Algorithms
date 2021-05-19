import java.util.*;
import java.io.*;
public class TopologicalSorting {
    static ArrayList[] graph;
    static int n;

    public static void initialiseGraph() {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
    }

    public static void addSomeNodes() {
        addEdge(1, 2);
        addEdge(2, 5);
        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(5, 8);
        addEdge(8, 9);
        addEdge(9, 10);
        addEdge(3, 7);
        addEdge(7, 11);
        addEdge(3, 12);
        addEdge(12, 14);
        addEdge(4, 6);
        addEdge(6, 14);
    }

    public static void addEdge(int u, int v) {
        graph[u].add(v);
    }

    public static void dfsTraversal() {
        boolean visited[] = new boolean[n];
        Stack<Integer> st = new Stack<>();
        System.out.println("------------DFS Traversal-----------");
        for (int i = 1; i < n; i++) {
            if (!visited[i]) {
                st.push(i);
                visited[i] = true;
                while (!st.isEmpty()) {
                    int curr = st.pop();
                    System.out.print(curr + " ");
                    Iterator<Integer> it = graph[curr].iterator();
                    while (it.hasNext()) {
                        int adj = it.next();
                        if (!visited[adj]){
                            st.push(adj);
                            visited[adj] = true;
                        }
                    }
                }
            }
        }
        System.out.println("\n---------------------------------\n\n\n");
    }

    public static void addNodesOnStack(int curr, Stack<Integer> ansStk,boolean visited[]){
        visited[curr]=true;
        Iterator<Integer> itr = graph[curr].iterator();
        while(itr.hasNext()){
            int adj = itr.next();
            if(!visited[adj]){
                addNodesOnStack(adj, ansStk,visited);
            }
        }
        ansStk.push(curr);
    }
    public static void topologicalSort() {
        boolean visited[] = new boolean[n];
        Stack<Integer> ansStk = new Stack<>();
        for(int i=1;i<n;i++){
            if(!visited[i]){
                addNodesOnStack(i, ansStk, visited);
            }
        }
        System.out.println("----------Topological ordering of the graph is ----------");
        while(!ansStk.empty()){
            System.out.print(ansStk.pop()+" ");
        }
        System.out.println("\n---------------------------------------------------------");
    }


    public static void bfsTraversal(){
        Queue<Integer> que = new LinkedList<>();
        boolean visited[]=new boolean[n];
        System.out.println("------------BFS Traversal-----------");
        for(int i=1;i<n;i++){
            if(!visited[i]){
                que.add(i);
                visited[i]=true;
                while(!que.isEmpty()){
                    int curr = que.poll();
                    visited[curr] = true;
                    System.out.print(curr + " ");
                    Iterator<Integer> adjIterator = graph[curr].iterator();
                    while(adjIterator.hasNext()){
                        int adj = adjIterator.next();
                        if(!visited[adj]){
                            que.add(adj);
                            visited[adj]=true;
                        }
                    }
                }
            }
        }
        System.out.println("\n---------------------------------\n\n\n");
    }
    public static void main(String args[]) {
        n = 15;
        initialiseGraph();
        addSomeNodes();
        dfsTraversal();
        bfsTraversal();
        topologicalSort();
    }
}

