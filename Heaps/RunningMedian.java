import java.util.*;
public class RunningMedian{
    public static void calculateAns(int arr[]){
        if(arr.length==1){
            System.out.println(arr[0]);
            return;
        }
        System.out.print(arr[0]+" ");
        int median=arr[0];
        PriorityQueue<Integer> maximum=new PriorityQueue<>();
        PriorityQueue<Integer> minimum=new PriorityQueue<>(arr.length,Collections.reverseOrder());
        minimum.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=median){
                maximum.add(arr[i]);
            }else if(arr[i]<median){
                minimum.add(arr[i]);
            }
            if(maximum.size()>(minimum.size()+1)){
                minimum.add(maximum.remove());
            }
            if(minimum.size()>(maximum.size()+1)){
                maximum.add(minimum.remove());
            }
            if(maximum.size()>minimum.size()){
                System.out.print(maximum.peek()+" ");
                median=maximum.peek();
            }
            else if(minimum.size()>maximum.size()){
                System.out.print(minimum.peek()+" ");
                median=minimum.peek();
            }else{
                System.out.print((minimum.peek()+maximum.peek())/2+" ");
                median=(minimum.peek()+maximum.peek())/2;
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={-10,14,11,-5,7,8};
        calculateAns(arr);
    }
}
// Expected Output:
// -10 2 11 3 7 7
