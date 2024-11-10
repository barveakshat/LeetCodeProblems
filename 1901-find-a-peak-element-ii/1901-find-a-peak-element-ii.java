class Solution {
    public int max_element(int[][] mat, int n,int m, int col){
        int max = -1;
        int idx = -1;
        for(int i=0; i<mat.length; i++){
            if(mat[i][col]>max){
                max = mat[i][col];
                idx = i;
            }
        }
        return  idx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m = mat[0].length;  int n = mat.length;
        int low = 0; int high = m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int row = max_element(mat, n,m, mid);
            int left = mid-1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid+1 < m ? mat[row][mid+1] : -1;

            if(mat[row][mid]>left && mat[row][mid]>right) return new int[] {row, mid};
            else if(mat[row][mid]<left) high = mid-1;
            else low = mid+1;
        }
        return new int[] { -1, -1 } ;
    }
}