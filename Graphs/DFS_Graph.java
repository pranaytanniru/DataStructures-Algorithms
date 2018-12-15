import java.util.*;
class DFS_Graph{
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
    addEdge(0,1);
		addEdge(0,2);
		addEdge(0,3);
		addEdge(0,4);
		addEdge(0,5);
		addEdge(1,1);
		addEdge(2,1);
		addEdge(3,1);
		addEdge(4,1);
		addEdge(5,1);
		addEdge(2,3);
  }
  public static void DFS(int u){
    Stack<Integer> st=new Stack<>();
    boolean visited[]=new boolean[Graph.length];
    st.push(u);
    visited[u]=true;
    while(st.size()!=0){
      int v=st.pop();
      System.out.print(v+" ");
      for(int i=0;i<Graph[v].size();i++){
        if(!visited[Graph[v].get(i)]){
          st.push(Graph[v].get(i));
          visited[Graph[v].get(i)]=true;
        }
      }
    }
  }
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=6;
    initialiseGraph(n);
    addSomeEdges();
    // printArrayList();
    DFS(2);
    System.out.println();

	}
}
