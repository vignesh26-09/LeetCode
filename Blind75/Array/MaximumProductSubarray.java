class MaximumProductSubarray{
    public static void main(String []args){
        int n []= {2,3,-2,4};
        System.out.println(maxProduct(n));
        System.out.println(maxProduct_Better(n));
        System.out.println(maxProduct_Optimal(n));

    }

    //Brute Force :
    // O(n^2) O(1)
    private static int maxProduct(int nums[]){
        int maxPro  =1 ;
        int n = nums.length;
        for(int i= 0 ; i<n ; i++){
            int pro =1;
            for(int j = i ; j<n ; j++){
                pro*=nums[j];
                maxPro = Math.max(maxPro , pro);
            }
        }
        return maxPro;
    }

    //Better:
    //
    private static int maxProduct_Better(int nums[]){
          int maxProduct = Integer.MIN_VALUE;
          int prefix = 1;
          int suffix = 1;
          int n = nums.length;
          for(int i =0 ;i<nums.length ;i++){
              if(prefix == 0){
                  prefix =1;
              }
              if(suffix == 0){
                  suffix =1;
              }
              prefix*=nums[i];
              suffix*=nums[n-1-i];
              maxProduct = Math.max(maxProduct, Math.max(prefix , suffix));
          }
          return maxProduct;
    }
    //Optimal :
    //O(n) O(1)
    private static int maxProduct_Optimal(int nums[]){
       int currentMax = nums[0];
       int currentMin = nums[0];
       int gMax = nums[0];
       for(int i =1; i< nums.length ; i++){
           int current = nums[i];
           int temp = currentMax;
           currentMax = Math.max(current , Math.max(current*currentMax , current*currentMin));
           currentMin = Math.min(current , Math.min(current*temp , current* currentMin));
           gMax = Math.max(gMax , currentMax);
       }
       return gMax;
    }
}