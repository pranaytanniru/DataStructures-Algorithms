//Link: https://www.hackerearth.com/practice/data-structures/disjoint-data-strutures/basics-of-disjoint-data-structures/tutorial/
// You are given number of nodes, N, and number of edges, M, of a undirected connected graph. 
// After adding each edge, print the size of all the connected components (in increasing order).
/*
Input:
First line contains two integers, N and M, number of nodes and number of edges.
Next M lines contains two integers each, X and Y, denoting that there is an edge between X and Y. 
*/
/*
    Sample Input:
        5 4
        1 2
        3 4
        4 5
        1 3
    Sample Output:
        1 1 1 2
        1 2 2
        2 3
        5
*/
import java.util.*;
class WeightedUnionBasic {
    public static int findParent(int arr[],int parent){
        while(arr[parent]!=parent){
            parent=arr[parent];
        }
        return parent;
    }
    public static void printResult(int arr[]){
        ArrayList<Integer> al=new ArrayList<>();
        for(int x=1;x<arr.length;x++){
            if(arr[x]>0)
                al.add(arr[x]);
        }
        Collections.sort(al);
        for(int x=0;x<al.size();x++){
            System.out.print(al.get(x)+" ");
        }
        System.out.println();
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int arr[]=new int[n+1];
        int size[]=new int[n+1];
        for(int i=1;i<arr.length;i++){
            arr[i]=i;
            size[i]=1;
        }
        for(int i=0;i<t;i++){
            int P=sc.nextInt();
            int C=sc.nextInt();
            
            int root_P=findParent(arr,P);
            int root_C=findParent(arr,C);
            if(root_P==root_C){
                continue;
            }
            size[root_P]+=size[root_C];
            arr[root_C]=root_P;
            size[root_C]=0;
            printResult(size);
        }
    }
}
