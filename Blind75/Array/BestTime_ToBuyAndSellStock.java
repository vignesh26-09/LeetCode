class BestTime_ToBuyAndSellStock{
    public static void main(String args[]){
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit_BruteForce(prices));
        System.out.println(maxProfit_BruteForce(prices));
        System.out.println(maxProfit_BruteForce(prices));
    }

    //BruteForce:
    // O(n^2) O(1)
    private static int maxProfit_BruteForce(int prices[]){
         int max_profit = 0;
         int n = prices.length;
         for(int i =0 ;i<n ;i++){
             for(int j = i+1 ; j<n ;j++){
                 max_profit = Math.max(prices[i]-prices[j] , max_profit);
             }
         }
         return max_profit;
    }

    //Better:
    //
    private static int maxProfit_Better(int prices[]){
        int n = prices.length;
        int minPrice[] = new int[n];
        minPrice[0]=prices[0];
        for(int i =1;i<n;i++){
            minPrice[i]=Math.min(minPrice[i-1], prices[0]);
        }
        int maxProfit =0;
        for(int i =1;i<n;i++){
            maxProfit = Math.max(maxProfit, prices[i]-minPrice[i-1]);
        }
        return maxProfit;
    }

    //Optimal :
    //O(n) O(1)
    private static int  maxProfit(int prices[]){
        int n = prices.length;
        int maxProfit =0;
        int minsoFar=Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            maxProfit=Math.max(maxProfit,prices[i]-minsoFar);
            minsoFar = Math.min(minsoFar, prices[i]);
        }
        return maxProfit;
    }
}