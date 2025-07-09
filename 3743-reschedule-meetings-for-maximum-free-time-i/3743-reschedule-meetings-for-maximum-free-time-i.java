class Solution {
    public int maxFreeTime(int eventTime, int k, int[] start, int[] end) {
        ArrayList<Integer> freeArr = new ArrayList<>();            // array of gaps
        freeArr.add(start[0]);                           // starting freetime
        for(int i=1; i<start.length; i++){
            freeArr.add(start[i] - end[i-1]);
        }
        freeArr.add(eventTime - end[end.length-1]);       // free time after end meeting 
        // SLIDING WINDOW
        int i = 0; int j = 0; 
        int maxSum = 0;
        int currSum = 0;
        int n = freeArr.size();
        while(j < n){
            currSum += freeArr.get(j);
            if(i < n && j-i+1 > k+1){     // Window size = k+1
                currSum -= freeArr.get(i);
                i++;
            }
            maxSum = Math.max(maxSum,currSum);
            j++;
        }
        return maxSum;
    }
}