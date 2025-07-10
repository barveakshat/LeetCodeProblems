class Solution {
    public int maxFreeTime(int eventTime, int[] start, int[] end) {
        ArrayList<Integer> freeArr = new ArrayList<>();            // array of gaps
        freeArr.add(start[0]);                           // starting freetime
        for(int i=1; i<start.length; i++){
            freeArr.add(start[i] - end[i-1]);
        }
        freeArr.add(eventTime - end[end.length-1]);       // free time after end meeting 
        int n = freeArr.size();

        ArrayList<Integer> maxLeftFree = new ArrayList<>(); 
        ArrayList<Integer> maxRightFree = new ArrayList<>(); 
        for(int i = 0; i < n; i++) {
            maxLeftFree.add(0);
            maxRightFree.add(0);
        }
        maxLeftFree.set(0, 0);
        maxRightFree.set(n-1, 0);

        for(int i=n-2; i>=0; i--){
            maxRightFree.set(i, Math.max(maxRightFree.get(i+1), freeArr.get(i+1))); 
        }
        for(int i=1; i<n; i++){
            maxLeftFree.set(i, Math.max(maxLeftFree.get(i-1), freeArr.get(i-1))); 
        }
        
        int result = 0;
        for(int i=1; i<n; i++){
            int currEventTime = end[i-1] - start[i-1];                 // duration of event d
            //CASE 1 - moving completely out
            if(currEventTime <= maxLeftFree.get(i-1) || currEventTime <= maxRightFree.get(i)){
                result = Math.max(result, freeArr.get(i-1) + currEventTime + freeArr.get(i));
            }
            // CASE 2 - shift left or right
            result = Math.max(result, freeArr.get(i-1) + freeArr.get(i));
        }
        return result;
    }
}