class Find_Min_INRotatedSortedArray{
    public static void main(String []args){
        int  nums [] = {3,4,5,1,2};
        System.out.println(isMinimum(nums));
        System.out.println(isMinimum_Better(nums));
        System.out.println(isMinimum_Optimal(nums));
    }

    //BruteForce:
    //O(n) O(1)
    private static int isMinimum(int nums[]){
        int min = nums[0];
        for(int i =1 ;i<nums.length ;i++){
            min = Math.min(min  , nums[i]);
        }
        return min;
    }

    //Better
    //O(n) O(1)
    // Find the break num > num+1
    private static int isMinimum_Better(int nums[]){
        int n = nums.length;
        for(int i = 1 ;i<n ; i++){
            if(nums[i]<nums[i-1]){
                return nums[i];
            }
        }
        //Array is sorted:
        return nums[0];
    }

    //Optimal
    //O(logn) O(1)
    //Binary search:
    private static int isMinimum_Optimal(int nums[]){
        int n = nums.length;
        int left =0;
        int right =n-1;

        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }
}