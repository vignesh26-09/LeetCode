import java.util.Arrays;
import java.util.HashMap;
import java.util.Comparator;
class TwoSum{
    public static void main(String args[]){
        int [] arr  = {2,7,11,15};
        int target = 9;
        //output : [1,2]
        System.out.println(Arrays.toString(twoSum_Brute(arr, target)));
        System.out.println(Arrays.toString(twoSum_Better(arr, target)));

        System.out.println(Arrays.toString(twoSum_Optimal(arr, target)));

    }
    //Brute Force:
    //O(n^2)  O(1)
    private static int[] twoSum_Brute(int [] arr , int target){
        int n = arr.length;
        if(n<2) return new int[0];

        for(int i =0 ;i<n-1;i++) {
            for (int j = i + 1; j < n; j++) {   // Adding two nearer Interger.Max_value can exceed the integer limit.
                long sum = (long) arr[i] + arr[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // Better (Sorting):
    // O(n logn ) O(n) for the value-pair array:
    private static int [] twoSum_Better(int arr[] , int target){
        int n = arr.length;
        if(n<2){
            return new int[0];
        }
        long[][] pairs = new long[n][2];
        for(int i = 0 ;i<n ; i++){
            pairs[i][0]= arr[i];
            pairs[i][1]= i;
        }
        Arrays.sort(pairs , Comparator.comparingLong(pair -> pair[0]));
        int left = 0;
        int right = n-1;
        while(left < right ){
            long sum = pairs[left][0]+pairs[right][0];
            if(sum == target){
                return new int[] {
                        (int)pairs[left][1], (int)pairs[right][1]
                };
            }
            if(sum < target) {
                left++;
            }
            else{
                right--;
            }

        }

        return new int[0];
    }
    // Optimal solution :
    // Using HashMap
    // O(n) o(n)
    private static int [] twoSum_Optimal(int [] arr  , int target){
        HashMap <Integer , Integer> hm = new HashMap<>();
        int n = arr.length;
        if(n<2){
            return new int[0];
        }
        for(int i = 0 ;i<arr.length ; i++){
             if(hm.containsKey(target-arr[i])){
                 return new int []{hm.get(target-arr[i]), i};
             }
             hm.put(arr[i], i);
        }
        return new int[0];
    }
}