class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int[] ar = new int[n * n], ac = new int[n * n];
        int[] br = new int[n * n], bc = new int[n * n];
        int na = 0, nb = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    ar[na] = i;
                    ac[na++] = j;
                }
                if (B[i][j] == 1) {
                    br[nb] = i;
                    bc[nb++] = j;
                }
            }
        }

        int size = (n << 1) - 1;
        int[] cnt = new int[size * size];
        int ans = 0, offset = n - 1;

        for (int i = 0; i < na; i++) {
            int r = ar[i] + offset;
            int c = ac[i] + offset;

            for (int j = 0; j < nb; j++) {
                int idx = (r - br[j]) * size + c - bc[j];
                if (++cnt[idx] > ans)
                    ans = cnt[idx];
            }
        }

        return ans;
    }
}