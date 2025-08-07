class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0; int right = left +1;

        while(right < prices.length){
            if(prices[left] > prices[right]){
                left = right;
            }else{
                maxProfit += prices[right] - prices[left];
                left = right;
            }
            right++;
            
        }
        return maxProfit;
    }
}