class Solution {
    public long countCommas(long n) {
        long ans = 0;
        if (n < 1000) return 0;
        long lb = 1000, ub = 999999;
        long c = 1;
        while (true) {
            if (n >= lb) {
                if (n > ub) {
                    ans += (ub - lb + 1L) * c;
                } else {
                    ans += (n - lb + 1L) * c;
                    break;
                }
                c++;
                lb = lb * 1000L;
                ub = ub * 1000L + 999L;
            }
        }
        return ans;
    }
}