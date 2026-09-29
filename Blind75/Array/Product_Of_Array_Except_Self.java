//Leetcode : 238
import java.util.*;
class Product_Of_Array_Except_Self{
    public static void main(String []args){
        int nums[]={1,2,3,4};
        System.out.println(Arrays.toString(product(nums)));
        System.out.println(Arrays.toString(product_Better(nums)));
        System.out.println(Arrays.toString(product_Optimal(nums)));
    }

    //Brute Force:
    //O(n^2) O(n) or O(1) for that output array if isn't counted.
    private static int [] product(int nums[]){
        int result [] = new int[nums.length];
        for(int i =0 ;i<nums.length ;i++){
            int product = 1;
            for(int j = 0 ; j<nums.length ; j++){
                if(i==j)continue;
                product*=nums[j];
            }
            result[i]= product;
        }
        return result;
    }

    //Better :
    //O(n) O(n)
    private static int []  product_Better(int nums[]){
        int n = nums.length;
        int result [] = new int[n];
        int prefix [] = new int[n];
        int suffix [] = new int[n];

        prefix[0] = 1;
        for(int i = 1; i<nums.length ; i++){
             prefix[i] = prefix[i-1]*nums[i-1];
       }
        suffix[n-1] = 1;
        for(int i = n-2 ; i>=0 ;i--){
            suffix[i]= suffix[i+1]*nums[i+1];
        }
        for(int i = 0 ;i<n;i++){
            result [i]= prefix[i]*suffix[i];
        }
        return  result;

    }

    //Optimal:
    //O(n) O(1) output array is required.
    private static int[] product_Optimal(int nums[]){
         int n = nums.length ;
         int result []= new int[n];
         result[0]=nums[0];
         for(int i =1 ;i<n ; i++){
             result[i]=result[i-1]*nums[i-1];
         }
         int suffix =1 ;
         for(int i = n-1 ; i >=0 ;i--){
             result[i]*=suffix;
             suffix*=nums[i];
         }
         return result ;
    }
}