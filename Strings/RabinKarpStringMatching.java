public class RabinKarpStringMatching{
    public static long[] getPowers(int M,int N,int X){
      long arr[]=new long[N+1];
      arr[0]=1;
      for(int i=1;i<arr.length;i++){
        arr[i]=(arr[i-1]*X)%M;
      }
      return arr;
    }
    public int strStr(final String A, final String B) {
        int Alen=A.length();
        int Blen=B.length();
        if(Alen==0 ||Blen==0 || Alen<Blen){
            return -1;
        }
        int M=(int)(1e9+7); // Mod value
        int X=131; // Prime
        long BHashVal=0,AHashVal=0;
        long pow1[]=getPowers(M,Blen,X);
        for(int i=Blen-1;i>=0;i--){
          BHashVal=(BHashVal+(B.charAt(Blen-1-i)*pow1[i+1])%M)%M;
        }
        for(int i=B.length()-1;i>=0;i--){
          AHashVal=(AHashVal+(A.charAt(Blen-1-i)*pow1[i+1])%M)%M;
        }
        if(AHashVal==BHashVal){
          return 0;
        }
        for(int i=Blen;i<Alen;i++){
          AHashVal=((((AHashVal-(A.charAt(i-Blen)*pow1[Blen])%M+M)%M)*X)%M + (A.charAt(i)*X)%M)%M;
          if(AHashVal==BHashVal){
            return i-Blen+1;
          }
        }
        return -1;
    }
    public static void main(String args[]){
      System.out.println((new RabinKarpStringMatching()).strStr("ThisIsPranayMahendra","Pranay"));
    }
}
// Output:
//   6
//
// The code here uses only single Hashing and there is a high chance of collision.
// Use Double Hashing to avoid collision
