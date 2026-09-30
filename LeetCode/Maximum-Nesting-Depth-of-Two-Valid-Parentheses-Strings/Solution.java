1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        int n = seq.length();
4        int[] res = new int[n];
5        for (int i = 0; i < n; i++)
6            res[i] = (i ^ seq.charAt(i)) & 1;
7        return res;
8    }
9}