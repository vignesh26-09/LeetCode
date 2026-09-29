//leetcode :15
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
class ThreeSum{
    public static void main(String []args){
        int nums [] ={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    //Brute Force:
    // O(n^3 O(n) no of triplets plus the temporary triplets
    private static List<List<Integer>> threeSum(int nums[]){
       // List<List<Integer>>result  = new ArrayList<>();    Can contain duplicate pairs.
        int n = nums.length;
        //Atleast three element needed:
        if(n<3) return new ArrayList<>();
        Set<List<Integer>>  result = new HashSet<>();
        for(int i = 0 ;i <n-2;i++){
            for(int j = i+1 ;j<n-1;j++){
                for(int k = j+1 ; k<n;k++){
                    //Integer overflow could occur:
                    long sum = (long) nums[i]+nums[j]+nums[k];
                    if( sum ==0){
                        List<Integer> triplet= Arrays.asList(nums[i] , nums[j] , nums[k]);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    //Better:
    //O(n^2) O(n)
    // Use Two sum approch , choose two and search for one.
    private static List<List<Integer>> threeSum(int nums[]){
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0 ;i<n ;i++){

        }
    }
}