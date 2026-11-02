class Solution {
    public int minMoves2(int[] nums) {
        int s=0,n=nums.length,c=0;
        Arrays.sort(nums);
        int avg=n/2;
        for(int i=0;i<n;i++)
        {
         if(i==avg) continue;
         if(nums[i]<nums[avg])
         {
          s=nums[avg]-nums[i];
          c+=s;
         }
         else{
            s=nums[i]-nums[avg];
            c+=s;
         }
        }
      return c;
    }
}