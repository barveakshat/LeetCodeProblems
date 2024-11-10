class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0; int high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            // finding how many numbers are missing upto a particular index
            int missing = arr[mid]-(mid+1);

            if(missing<k) low=mid+1;
            else high = mid-1;
        }
        return (low+k);    // or (high+1+k)
        /**
        how to find this formula (k+high+1)
        
        answer = arr[high] + more
               = arr[high] + k - missing
               = arr[high] + k - (arr[high] - high-1)
               = arr[high] + k - arr[high] + high + 1;

        answer = k + high + 1
         */
    }
}