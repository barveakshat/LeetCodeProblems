class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if(n==1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!=arr[n-2]) return arr[n-1];
        // edge cases: first and last elements are not included as they will create index out of bound
        int low = 1; int high = n-2;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }
            // left part elimination:
            if((mid%2==1 && arr[mid-1]==arr[mid]) || (mid%2==0 && arr[mid]==arr[mid+1]))
            {   
                low=mid+1;
            }
            // right part elimination
            else {
                high=mid-1;
            }

        } return -1; 
    }
}