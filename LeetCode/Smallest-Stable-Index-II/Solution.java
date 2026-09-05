1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        int[] suffixMin = new int[n];
5        suffixMin[n - 1] = nums[n - 1];
6        for (int i = n - 2; i >= 0; i--) {
7            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
8        }
9        int prefixMax = nums[0];
10        for (int i = 0; i < n; i++) {
11            prefixMax = Math.max(prefixMax, nums[i]);
12            int instability = prefixMax - suffixMin[i];
13            if (instability <= k) {
14                return i;
15            }
16        }
17        return -1;
18    }
19}