class Solution {
    public int maxProfit(int[] prices) {
        int small=prices[0];
        int large=0;
        int n=prices.length;
        for(int i=0;i<n;i++){
                if (prices[i]<small){
                    small=prices[i];
                }
            else if(prices[i]-small>large){
                large=prices[i]-small;
            }
                }
        return large;
    }
}