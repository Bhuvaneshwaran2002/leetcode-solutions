class Solution {
    public int climbStairs(int n, int[] cost) {
        int dp[]=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i] = cost[i-1]+1;
            }else if(i==2){
                dp[i] = Math.min(dp[1]+cost[i-1]+1,cost[i-1]+4);
            }else{
                int l3 = cost[i-1]+  9 + dp[i-3];
                int l2 = cost[i-1] + 4 + dp[i-2];
                int l1 = cost[i-1] + 1 +dp[i-1];
                dp[i] = Math.min(l1,Math.min(l2,l3));
            }
        }
        return dp[n];
    }
}