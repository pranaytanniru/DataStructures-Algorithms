import java.lang.*;
import java.util.*;
class ItemObject implements Comparable<ItemObject>{
    int itemVal,itemIndex;
    public ItemObject(int itemVal,int itemIndex){
        this.itemIndex=itemIndex;
        this.itemVal=itemVal;
    }
    public int compareTo(ItemObject O){
      return this.itemVal-O.itemVal;
    }
}
public class SortObjectsComparable {
    public static void sort(int[] A){
        int index[]=new int[A.length];
        ItemObject items[]=new ItemObject[A.length];
        for(int i=0;i<A.length;i++){
            items[i]=new ItemObject(A[i],i+1);
        }
        System.out.println("Before sorting");
        print(items);
        System.out.println();
        Arrays.sort(items);
        System.out.println("After sorting");
        print(items);
        System.out.println();
    }
    public static void print(ItemObject items[]){
      for(int i=0;i<items.length;i++){
        System.out.println(items[i].itemVal+" -> "+items[i].itemIndex);
      }
    }
    public static void main(String args[]){
      int arr[]={10,8,3,6,2,7};
      sort(arr);
    }
}
