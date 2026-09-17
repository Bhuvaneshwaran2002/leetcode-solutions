class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        final int INF = 1_000_000_000;
        final int size = arr.length;
        int ans = INF;
        int l = 0;
        int sum = 0;

        // For right pointer
        int[] best = new int[size];
        Arrays.fill(best, INF);

        for (int r = 0; r < size; r++) {
            sum += arr[r];

            // Greater sum
            while (sum > target) {
                sum -= arr[l++];
            }

            // Target
            if (sum == target) {
                int curr = r - l + 1;

                // No overlapping, l-1 is last r i.e first subarray
                if (l > 0 && best[l - 1] != INF) {
                    ans = Math.min(ans, curr + best[l - 1]);
                }

                best[r] = curr;
            }

            // To keep min track of first subarray 
            if (r > 0) {
                best[r] = Math.min(best[r], best[r - 1]);
            }
        }

        return (ans == INF) ? -1 : ans;
    }
}