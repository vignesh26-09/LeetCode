//Leetcode : 217
import java.util.HashSet;
import java.util.Arrays;
class ContainsDuplicate{
    public static void main(String [] args){
        int nums[] = {1,2,3,1};
        System.out.println(isDuplicate(nums));
        System.out.println(isDuplicate_Better(nums));
        System.out.println(isDuplicate_Optimal(nums));
    }
    //Brtue Force:
    //O(n^2) O(1)
    private static boolean isDuplicate(int [] nums){
        int  n = nums.length;
        for(int i =0 ;i<n-1;i++){
            for(int j = i+1 ; j<n ;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //Better:
    //O(nlogn) O(1)
    private static boolean isDuplicate_Better(int nums[]){

        if(nums.length<2)return false;
        Arrays.sort(nums);
        for(int i =0 ;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
    }

    //Optimal:
    //O(n) O(1)
    private static boolean isDuplicate_Optimal(int nums[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}