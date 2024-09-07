class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0; int high = n-1 ; 
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            } 
            // identifying the sorted half:
            // condition for left part to be sorted:
            if(nums[low]<=nums[mid]){
                //check for target in left sorted part
                if(nums[low]<=target && target<=nums[mid]){
                    high = mid-1;
                }
                else low=mid+1;
            }
            // condition for right part to be sorted
            else{
                if(nums[mid]<=target && target<=nums[high]){
                    low=mid+1;
                }
                else high = mid-1;
            }
           
        }
        return -1;
    }
}