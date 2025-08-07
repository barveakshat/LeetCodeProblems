class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int n = prices.length;

        int l = 0;  int r = l+1;
        while(r < n){
            if(prices[l] < prices[r]){
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }else{
                l = r;
            }
            r++;
        }
        return maxProfit;
        
    }
}