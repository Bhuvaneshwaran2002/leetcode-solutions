class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans1 = (long) cost1 * need1 + (long) cost2 * need2;
        long ans2 = (long) costBoth * Math.max(need1,need2);
        long common = Math.min(need1 , need2);
        long ans3 = (long) common * costBoth + (long) (need1-common) * cost1 + (long)(need2-common)*cost2;
        return Math.min(ans3 , Math.min(ans2 , ans1));
    }
}