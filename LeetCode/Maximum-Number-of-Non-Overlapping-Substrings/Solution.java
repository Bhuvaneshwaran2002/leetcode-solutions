class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        // Record first and last occurrence for each letter.
        int[] left = new int[26], right = new int[26];
        java.util.Arrays.fill(left, n);
        java.util.Arrays.fill(right, -1);
        for (int i = 0; i < n; i++){
            int c = s.charAt(i) - 'a';
            left[c] = Math.min(left[c], i);
            right[c] = i;
        }
        
        // List to store candidate intervals [l, r] that satisfy:
        // For every character c in s[l..r], left[c] >= l and right[c] <= r.
        List<int[]> candidates = new java.util.ArrayList<>();
        for (int c = 0; c < 26; c++){
            if (right[c] == -1) continue; // letter c doesn't appear
            int l = left[c], r = right[c];
            int j = l;
            boolean valid = true;
            while (j <= r) {
                int cur = s.charAt(j) - 'a';
                // If a character in this interval has an occurrence before l, candidate is invalid.
                if (left[cur] < l) { 
                    valid = false; 
                    break;
                }
                r = Math.max(r, right[cur]);
                j++;
            }
            if (valid) {
                candidates.add(new int[]{l, r});
            }
        }
        
        // Sort candidates by their right boundary.
        candidates.sort((a, b) -> a[1] - b[1]);
        
        // Greedy select non-overlapping intervals.
        List<String> res = new java.util.ArrayList<>();
        int prevEnd = -1;
        for (int[] cand : candidates) {
            if (cand[0] > prevEnd) {
                res.add(s.substring(cand[0], cand[1] + 1));
                prevEnd = cand[1];
            }
        }
        return res;
    }
}
