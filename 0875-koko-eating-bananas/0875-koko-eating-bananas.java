class Solution {
    // finding max element in piles[] to get the range for binary search, because at that max value kok can eat all bananas in minimum hours
    public int findmax(int[] piles){
        int maxi = Integer.MIN_VALUE;
        int n = piles.length;
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi,piles[i]);
        }
        return maxi;
    }
    // Calculating total hours taken by dividing each element in piles by the mid value of binary search
    public int calculateTotalHours(int[] piles, int hourly){
        int th = 0;
        for(int i=0; i<piles.length; i++){
            th += Math.ceil((double)(piles[i]) / (double)(hourly));
        } return th;
    }
    // binary search 
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0; int high = findmax(piles);
        while(low<=high){
            int mid = (low + high)/2;
            int totalH = calculateTotalHours(piles, mid);
            if(totalH<=h){
                high = mid-1;

            }else{
                low = mid+1;
            }
        }
        return low;  // since finally at the end of bs, high will point previous to low so low would be the answer      
    }
}