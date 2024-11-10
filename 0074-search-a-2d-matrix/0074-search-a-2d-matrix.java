class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length;  int n = mat[0].length;

        if(mat==null || m<1 || n<1) return false;
        
        int low = 0; int high = n*m-1;
        while(low<=high){
            int mid = (low+high)/2;

            // imagine the matrix as 1D array and do BS
            // just here we need to get the matrix location of mid  element by following formula
            int row = mid/n;  int col = mid%n;

            if(mat[row][col]==target) return true;
            else if(mat[row][col]<target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}