1class Solution {
2    public long maxAlternatingSum(int[] nums) {
3        long [] ans=new long[nums.length];
4        for(int i=0;i<nums.length;i++)
5        {
6            ans[i]=(long)nums[i]*nums[i];
7        }
8        Arrays.sort(ans);
9        long sum=0;
10        int first=0,last=nums.length-1;
11        while(first<=last)
12        {
13            sum+=ans[last];
14            last--;
15            if(first<=last)
16            {
17            sum-=ans[first];
18            first++;
19            }
20        }
21       return sum;
22    }
23}