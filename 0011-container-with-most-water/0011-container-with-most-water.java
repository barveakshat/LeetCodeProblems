class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        int i=0; 
        int j=n-1;
        while(i<j){
            int a=height[i]; int b=height[j];
            max = Math.max(max, (j-i)*Math.min(a,b));
            if(a<=b)  i++;
            else j--;

        }
        return max;
    }
}