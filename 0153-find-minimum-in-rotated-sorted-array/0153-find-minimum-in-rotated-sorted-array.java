class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0; int high=n-1; int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            // if the search space is already sorted:
            if(nums[low]<=nums[high]){
                ans = Math.min(ans, nums[low]);
                break;
            }
            // condition for the left part to be sorted
            if(nums[low]<=nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid+1;
            }
            // condition for the right part to be sorted
            else{
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}