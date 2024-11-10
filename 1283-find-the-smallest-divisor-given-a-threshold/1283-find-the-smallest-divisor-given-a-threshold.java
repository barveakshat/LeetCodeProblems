class Solution {
    public int findSum(int[] nums, int x){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += Math.ceil((double)nums[i]/(double)x);
        }
        return sum;
    }
    public int maxelement(int[] nums){
        int max = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }return max;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1; int high = maxelement(nums);
        while(low<=high){
            int mid = low + (high-low)/2;
            if(findSum(nums,mid)<=threshold) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}