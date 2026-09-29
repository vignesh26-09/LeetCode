class SumOf_Integers{
    public static void main(String []args){
        int a = 1;
        int b = 2;
        System.out.println(Sum(a,b));
    }
    //Optimal :
    //O(1) O(1)
    private static int Sum(int a , int b){
        while(b!=0){
            int carry = (a&b)<<1;
            a = a^b;
            b = carry;
        }
        return a;
    }
}