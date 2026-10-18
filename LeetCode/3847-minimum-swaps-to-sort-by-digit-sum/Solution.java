class Solution {
    public int minSwaps(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int n = nums.length;
        int[][] ar = new int[n][2];
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            int sum = sumOfNums(num);
            indexMap.put(num, i);
            ar[i][0] = num;
            ar[i][1] = sum;
        }
        Arrays.sort(ar, (a,b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            Set<Integer> set = new HashSet<>();
            int index = i;
            while (!set.contains(ar[index][0])) {
                visited[index] = true;
                set.add(ar[index][0]);
                index = indexMap.get(ar[index][0]);
            }
            res += set.size() - 1;
        }
        return res;
    }
    private int sumOfNums(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}