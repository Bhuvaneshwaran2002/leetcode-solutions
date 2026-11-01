class Solution {
    public int minMoves(int[] nums) 
    {
        int n=nums.length;
        int step=0;
        int min=nums[0];
        for(int i:nums)
        if(i<min)
            min=i;
        for(int i=0;i<n;i++)
        step+=nums[i]-min;
        return step;        
    }
}