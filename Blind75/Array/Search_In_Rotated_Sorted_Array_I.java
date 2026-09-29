class Search_In_Rotated_Sorted_Array_I {
    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(findElement(nums, target));
        System.out.println(findElement_Better(nums, target));
        System.out.println(findElement_Optimal(nums, target));
    }

    //Brute Force:
    //O(n) o(1)
    private static int findElement(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //Better:
    //O(logn) O(1)
    private static int findElement_Better(int nums[], int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int pivot = left;
        if (target >= nums[pivot] && target <= nums[n - 1]) {
            left = pivot;
            right = n - 1;
        } else {
            left = 0;
            right = pivot - 1;
        }

        while (left <=right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Optimal :
    //O(log n ) O(1)
    //single binary search
    private static int findElement_Optimal(int nums[] , int target){
        int left = 0 ;
        int right = nums.length-1;
        while(left <= right){
            int mid= left +(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            //see left half is sorted or not:
            if(nums[left]<= nums[mid]){
                if(target>=nums[left] && target<=nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if(target>=nums[mid] && target<= nums[right]){
                    left = mid+1;
                }
                else {
                    right =  mid-1;
                }
            }
        }
        return -1;
    }
}