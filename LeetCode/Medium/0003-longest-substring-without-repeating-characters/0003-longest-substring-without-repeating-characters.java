class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int l = 0;
        Set<Character> set = new HashSet<>();

        for(int c = 0; c < s.length(); c++){
            while(set.contains(s.charAt(c))){
                set.remove(s.charAt(l));
                l++;
            }
            
            set.add(s.charAt(c));
            ans = Math.max(ans, c - l + 1);
        }


        return ans;
    }
}