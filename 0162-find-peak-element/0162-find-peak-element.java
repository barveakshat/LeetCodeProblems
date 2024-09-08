class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int low=1; int high=n-2;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            // if mid is in increasing direction, then peak will be in right, so eliminate the left half
            else if(nums[mid]>nums[mid-1]){
                low = mid+1;
            }
            // if mid is in decreasing direction, then peak will be in left, so eliminate the right half
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}