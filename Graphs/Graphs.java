import java.util.*;
class Graphs{
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
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
    initialiseGraph(n);
    addSomeEdges();
		printArrayList();
	}
}
