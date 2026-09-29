import java.util.Arrays;
class CountingBits{
    public static void main(String []args){
        int n = 2;
        System.out.println(Arrays.toString(count_bits(n)));
        System.out.println(Arrays.toString(count_Optimal(n)));

    }

    //Brute Force:
    //O(n log n ) n integers log n checks O(n)
    private static int[] count_bits(int n ){
        int result [] = new int[n+1];
        for(int i = 0 ; i<=n;i++){
            int c = i ;
            int count = 0;
            while(c != 0){
                count+=(c&1);
                c>>>=1;
            }
            result[i]=count;
        }
        return result;
    }

    //Better And Optimal:
    //O(n) O(n)for dp
    //Dp plus Brian kernighan  for every number:
    private static int[] count_Optimal(int n){
        int result []  = new int[n+1];
        result[0]=0;
        for(int i = 1; i<=n;i++){
            result[i]= result[i>>1]+(i&1);
        }
        return result;
    }
}