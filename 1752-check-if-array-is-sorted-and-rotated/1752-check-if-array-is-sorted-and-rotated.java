class Solution {
    public boolean check(int[] nums) {
        int x=0;    // x is a counter for number of violations 
        for(int i=0; i<nums.length; i++){
            if(nums[i]>nums[(i+1)%nums.length]){
                x++;
            }
            if(x>1){
                return false;
            }
        }
        return true;
    } 
}