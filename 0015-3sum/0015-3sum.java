import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // Sort the array first
        List<List<Integer>> l = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the main element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int res = 0 - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            
            while (start < end) {
                int sum = nums[start] + nums[end];
                
                if (sum == res) {
                    l.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    
                    // Skip duplicates for start and end
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    
                    start++;
                    end--;
                } else if (sum > res) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return l;
    }
}