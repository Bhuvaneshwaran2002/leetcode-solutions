class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (cnt > 0) res.append(c);
                cnt++;
            } else {
                cnt--;
                if (cnt > 0) res.append(c);
            }
        }
        return res.toString();
    }
}