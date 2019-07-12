// https://www.interviewbit.com/problems/n-max-pair-combinations/
class Item implements Comparable<Item>{
    int firstIndex,secondIndex,val;
    public Item(int firstIndex,int secondIndex,int val){
        this.firstIndex=firstIndex;
        this.secondIndex=secondIndex;
        this.val=val;
    }
    public int compareTo(Item item){
        return this.val-item.val;
    }
}
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A,Collections.reverseOrder());
        Collections.sort(B,Collections.reverseOrder());
        PriorityQueue<Item> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Item(0,0,A.get(0)+B.get(0)));
        HashSet<String> hs=new HashSet<>();
        hs.add(0+" "+0);
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            Item temp=pq.remove();
            int i1=temp.firstIndex;
            int i2=temp.secondIndex;
            ans.add(temp.val);
            if((i1+1)<A.size() && !hs.contains((i1+1)+" "+i2)){
                pq.add(new Item(i1+1,i2,A.get(i1+1)+B.get(i2)));
                hs.add((i1+1)+" "+i2);
            }
            if((i2+1)<B.size() && !hs.contains(i1+" "+(i2+1))){
                pq.add(new Item(i1,i2+1,A.get(i1)+B.get(i2+1)));
                hs.add(i1+" "+(i2+1));
            }
        }
        return ans;
    }
}
