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
        System.out.println(threeSum_Better(nums));
        System.out.println(threeSum_Optimal(nums));
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
    private static List<List<Integer>> threeSum_Better(int nums[]){
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0 ;i<n;i++){
            Set<Integer> seen = new HashSet<>();
             for(int j = i+1 ; j<n;j++){
                 long remain = -((long)nums[i]+nums[j]);
                 if(remain >=Integer.MIN_VALUE && remain <=Integer.MAX_VALUE){
                     int rem = (int )remain;
                     if(seen.contains(rem)){
                         List<Integer> temp = Arrays.asList(nums[i],nums[j],rem);
                         Collections.sort(temp);
                         result.add(temp);
                     }
                 }
                 seen.add(nums[j]);
             }

        }
        return new ArrayList<>(result);
    }

    //Optimal :
    //O(nlogn )
    private static List<List<Integer>> threeSum_Optimal(int nums[]){
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0 ; i<n;i++){
            if(i>0 &&  nums[i]==nums[i-1]){
                continue;
            }
            //Since it is sorted , no other element after that could give a zero sum.
            if(nums[i]>0){
                break;
            }
            int left =i+1;
            int right = n-1;
            while(left<right){
              long sum = (long)nums[i]+nums[left]+nums[right];
              if(sum == 0){
                  result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                  left++;
                  right--;
                  while(left<right && nums[left]==nums[left-1]){
                      left++;
                  }
                  while(left<right && nums[right]==nums[right+1]){
                      right--;
                  }
              }
              else if(sum<0){
                  left++;
              }
              else{
                  right--;
              }
            }
        }
        return result;
    }
}