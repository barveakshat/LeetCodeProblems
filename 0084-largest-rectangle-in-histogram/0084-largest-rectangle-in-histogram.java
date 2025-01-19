class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0;i<n;i++){     //NSR
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.size()==0) left[i]=-1;
            else left[i] = s.peek();
            s.push(i);
        }
        while(!s.isEmpty()) s.pop();

        for(int i=n-1;i>=0;i--){     //NSL
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.size()==0) right[i]=n;
            else right[i] = s.peek();
            s.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }
}