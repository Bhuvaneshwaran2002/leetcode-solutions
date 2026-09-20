1class Solution {
2    public int reverseDegree(String s) {
3        int sum = 0;
4        for (int i = 0; i < s.length(); i++) {
5            var index = s.charAt(i) - 'a';
6            sum += (26 - index) * (i + 1);
7        }
8        return sum;
9    }
10}