class Solution {
    public void merge(int []nums,int low,int mid,int high)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        int i=low;
        int j=mid+1;
        while(i<=mid && j<=high)
        {
            if(nums[i]<=nums[j])
            {
                temp.add(nums[i]);
                i++;
            }
            else
            {
                temp.add(nums[j]);
                j++;
            }
        }
        while(i<=mid)
        {
            temp.add(nums[i]);
            i++;
        }
        while(j<=high)
        {
            temp.add(nums[j]);
            j++;
        }
        for( i=low;i<=high;i++)
        {
            nums[i]=temp.get(i-low);
        }
    }
    public int countpairs(int []nums,int low,int mid,int high)
    {
        int right=mid+1;
        int count=0;
        for(int i=low;i<=mid;i++)
        {
            while(right<=high && nums[i]> 2L *nums[right])
            {
                right++;
            }
            count+=(right-(mid+1));
        }
        return count;
    }
    public int mergesort(int [] nums,int low,int high)
    {
          int count=0;
          if(low>=high) return 0;
          int mid=(low+high)/2;
          count+=mergesort(nums,low,mid);
          count+=mergesort(nums,mid+1,high);
          count+=countpairs(nums,low,mid,high);
          merge(nums,low,mid,high);
           return count;
    }
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }
}