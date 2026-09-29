class ReverseBits{
    public static void main(String []args){
     int n = 43261596;
     System.out.println(reverseBits(n));
    }
    private static long reverseBits(int n){
       int result = 0 ;
       for(int i =  0;i<32 ;i++){
           int bit = n&1;
           result<<=1;
           result|=bit;
           n>>>=1;
       }
       return result;
    }
}