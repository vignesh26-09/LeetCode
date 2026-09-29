class ContainerWithMoreWater{
    public static void main(String []args){
       int heights[] ={1,8,6,2,5,4,8,3,7};
       System.out.println(mostWater(heights));
       System.out.println(mostWater(heights));
    }

    //Brute Force:
    //O(n^2) O(1)
    private static int mostWater(int h[]){
        int n = h.length;
        int maxArea=0;
        for(int i =0 ; i<n ;i++){
            for(int j =i+1;j<n;j++){
                int width = j-i;
                int height =  Math.min(h[i], h[j]);
                int area = width * height;
                maxArea = Math.max(maxArea , area);
            }
        }
        return maxArea;
    }

    //Better Or Optimal:
    //O(n ) O(1)
    private static int mostWater_Optimal(int h[]){
        int left = 0 ;
        int right = h.length-1;
        int maxArea = 0;
        while(left< right){
            int width = right - left;
            int min_h = Math.min(h[left] , h[right]);
            int area = width*min_h;
            maxArea = Math.max(maxArea , area);
            if(h[left]<h[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}