class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        // Set<Integer> res = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(nums[j] == key && Math.abs(i-j) <= k){
                    set.add(i);
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}