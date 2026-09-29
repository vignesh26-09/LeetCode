public class LastDigit{
    public static void main(String [] args){
      int no =3;
      int power = 10;
      System.out.println("The Last Digit :"+findLastDigit_Better(no , power));
    }
    private static int findLastDigit_Brute_force(int n , int power){
        long result = 1;
        for(int i = 1 ; i<=power ; i++){
            result *=n;
        }
        return ((int)result%10);
    }
    private static int findLastDigit_Better(int no , int power){
        int result =1;
        for(int i =0 ;i< power   ;i++){
            result = (result*no)%10;
        }
        return result;
    }
    private static int findLastDigit(int n , int power){
        int powered = (int)Math.pow(n,power);
        return powered%10;
    }
}