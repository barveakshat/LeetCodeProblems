class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int l = 0;
        Set<Character> set = new HashSet<>();

        for(int r = 0; r < s.length(); r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            
            set.add(s.charAt(r));
            ans = Math.max(ans, r - l + 1);
        }


        return ans;
    }
}