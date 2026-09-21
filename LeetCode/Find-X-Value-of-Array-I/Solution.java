class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] res=new long[k];
        long[] dp=new long[k];
        for(int num:nums)
        {
            int x=num%k;
            long[] next=new long[k];
            next[x]+=1;
            for(int r=0;r<k;r++)
            {
                next[(r*x)%k]+=dp[r];
            }
            for(int r=0;r<k;r++)
            {
                res[r]+=next[r];
            }
            dp=next;
        }
        return res;
    }
}