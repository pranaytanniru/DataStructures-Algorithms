import java.lang.*;
import java.util.*;
class ItemObject{
    int itemVal,itemIndex;
    public ItemObject(int itemVal,int itemIndex){
        this.itemIndex=itemIndex;
        this.itemVal=itemVal;
    }
}
public class SortObjects {
    public static void sort(int[] A){
        int index[]=new int[A.length];
        ItemObject items[]=new ItemObject[A.length];
        for(int i=0;i<A.length;i++){
            items[i]=new ItemObject(A[i],i+1);
        }
        System.out.println("Before sorting");
        print(items);
        System.out.println();
        Arrays.sort(items,new Comparator<ItemObject>(){
              public int compare(ItemObject o1, ItemObject o2)
              {
                 return o1.itemVal-o2.itemVal;
              }
        });
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
