class Solution {
    static int lowerBound(int[] arr, int x){
        int  n = arr.length;
        int low=0; int high=n-1; int lb = n;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=x){
                lb = mid;  high = mid-1;
            }
            else low=mid+1;
        }return lb;
    }
    static int upperBound(int[] arr, int x){
        int  n = arr.length;
        int low=0; int high=n-1; int lb = n;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>x){
                lb = mid;  high = mid-1;
            }
            else low=mid+1;
        }return lb;
    }
    public int[] searchRange(int[] nums, int x) {
        int n = nums.length;
        int[] result = new int[2];
        // starting position = lower bound
        // ending position = upperbound - 1
        int lb = lowerBound(nums, x);
        // critical conditions:
        // 1. when lb=n
        // 2. if the target is not present in array and lb points to element !=x
        if(lb==n || nums[lb]!=x){
            result[0]=-1; result[1]=-1;
            return result;
        }
        int ub = upperBound(nums, x) - 1;
        result[0]=lb;   result[1]=ub;
        return result;
    }
}