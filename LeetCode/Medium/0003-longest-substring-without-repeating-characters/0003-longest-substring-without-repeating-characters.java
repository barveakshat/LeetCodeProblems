class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int length = 0;
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(set.add(c)){
                length++;
                
            }else{
                length = 1;
                set.clear();
                set.add(c);
            }
            ans = Math.max(ans, length);
        }
        return ans;
    }
}