
class Solution 
{
    public int beautySum(String s) 
    {
        int ans =0;
        int n = s.length();
        for(int i=0; i<=n-1; i++)
        {
            int freq[] = new int[26]; // Total 26 alphabets are there.
            for(int j=i; j<=n-1; j++)
            {
                freq[s.charAt(j) - 'a']++; // Jo bhi element ayega uski frequency badhate gaye.

                int max = getMax(freq);
                int min = getMin(freq);

                int beauty = max - min;
                ans = ans + beauty;
            }
        }
        return ans;
    }

    public static int getMax(int[] freq)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<26; i++)
        {
            max = Math.max(freq[i], max);
        }
        return max;
    }

    public static int getMin(int[] freq)
    {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<26; i++)
        {
            if(freq[i] != 0)
            {
                min = Math.min(freq[i], min);
            }
        }
        return min;
    }
}