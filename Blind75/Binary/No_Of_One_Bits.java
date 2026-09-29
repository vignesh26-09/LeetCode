class No_Of_One_Bits{
    public static void main(String [] args){
        int n = 11;
        System.out.println(noOfBits(n));
        System.out.println(noOfBits_Better(n));
        System.out.println(noOfBits_Optimal(n));
    }

    //Brute Force:
    //O(1) as it is 32 bits  O(1) with fixed integers
    private static int noOfBits(int n ){
        String bin = Integer.toBinaryString(n);
        int count =  0 ;
        for( char b : bin.toCharArray()){
            if(b == '1'){
                count++;
            }
        }
        return count;
    }

    //Better:
    //O(1)  O(1)
    private static int noOfBits_Better(int n){
          int count = 0;
          while (n!=0){
              count += (n&1);
              n>>>=1;
          }
          return count;
    }

    //Optimal:
    //O(1)
    private static int noOfBits_Optimal(int n ){
        int count = 0;
        while(n!=0){
            n = n&n-1;
            count++;
        }
        return count;
    }
}