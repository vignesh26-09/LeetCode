public class Odd_Or_Even{
    public  static void main( String[] args){
        int no =10;
        if(isOddOrEven_N(no)){
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
    }
    private  static boolean isOddOrEven(int n ){
        return n%2==0;
    }
    private  static boolean isOddOrEven_N(int n ){
        return (n&1)==0;
    }
}