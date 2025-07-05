class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        // ArrayList<Integer> ele = new ArrayList<>();
        int largest = -1;
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
                continue;
            }
           
            map.put(arr[i],map.get(arr[i])+1);
        }
        for(int i=0; i<arr.length; i++){
            int freq = map.get(arr[i]);
            if(freq == arr[i]){
                largest = Math.max(largest, arr[i]);
            }
        }
        
        
        return largest;
    }
}