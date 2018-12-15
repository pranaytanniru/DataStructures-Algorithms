import java.util.*;
class BFS_GRAPH{
	public static LinkedList<Integer>[] Graph;
	public static void addEdge(int u,int v){
    if(u==v){
			Graph[u].add(v);
			return;
		}
		Graph[u].add(v);
		Graph[v].add(u);
	}
	public static void printArrayList(){
		for(int i=0;i<Graph.length;i++){
			System.out.println(Arrays.toString(Graph[i].toArray()));
		}
	}
  public static void initialiseGraph(int n){
    Graph=new LinkedList[n];
		for(int i=0;i<n;i++){
			Graph[i]=new LinkedList<>();
		}
  }
  public static void addSomeEdges(){
    addEdge(0, 1);
    addEdge(0, 2);
    addEdge(1, 2);
    addEdge(2, 0);
    addEdge(2, 3);
    addEdge(3, 3);
  }
  public static void BFS(int u){
    boolean visited[]=new boolean[Graph.length];
    Queue<Integer> que=new LinkedList<>();
    visited[u]=true;
    que.add(u);
    while(que.size()!=0){
      int v=que.poll();
      System.out.print(v+" ");
      for(int i=0;i<Graph[v].size();i++){
        if(!visited[Graph[v].get(i)]){
          visited[Graph[v].get(i)]=true;
          que.add(Graph[v].get(i));
        }
      }
    }
  }
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=6;
    initialiseGraph(n);
    addSomeEdges();
    BFS(2);
		// printArrayList();
	}
}
