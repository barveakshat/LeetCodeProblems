class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        // ArrayList<Integer> ele = new ArrayList<>();
        int largest = -1;
        
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int key : map.keySet()){
            
            if(map.get(key) == key){
                largest = Math.max(largest, key);
            }
        }
        
        
        return largest;
    }
}