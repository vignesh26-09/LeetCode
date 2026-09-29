import java.util.HashSet;
class FindMissingNumber{
    public static void main(String []args){
        int nums []= {3,0,1};
        System.out.println(findMissing(nums));
        System.out.println(findMissing_Better(nums));
        System.out.println(findMissing_Optimal(nums));
        System.out.println(findMissing_Optimal_2(nums));
    }

    //Brute Force:
    //O(n^2) O(1)
    private static int findMissing(int [] nums){
        int n = nums.length;
        for(int i = 0 ; i<=n;i++){
             int num =  i ;
             boolean found = false;
             for(int j = 0 ;j<n ; j++){
                 if (nums[j]==num){
                     found = true;
                     break;
                 }
             }
             if(!found)return num;
        }
        return -1;
    }

    //Better:
    //Hashset:
    //O(n) O(n)
    private static int findMissing_Better(int [] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        for(int i = 0 ;  i<=nums.length ;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }

    //Optimal:
    //O(n) O(1)
    private static int findMissing_Optimal(int [] nums){
        int total = 0 ;  // use long
        int n = nums.length;
        for(int i = 0 ;i<n; i++){
            total+=nums[i];
        }
        int real_total = n*(n+1)/2;
        return real_total - total;
    }

    private static int findMissing_Optimal_2(int [] nums){
        int n = nums.length;
        int xor = n;
        for(int i = 0 ; i<n;i++){
            xor^=i;
            xor^=nums[i];
        }
        return xor;
    }
}