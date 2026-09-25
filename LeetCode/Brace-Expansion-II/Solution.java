import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = expand(expression);
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    private Set<String> expand(String expr) {
        Set<String> result = new HashSet<>();
        
        if (!expr.contains("{")) {
            result.add(expr);
            return result;
        }
        
        int level = 0;
        int start = -1;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '{') {
                if (level == 0) start = i;
                level++;
            } else if (expr.charAt(i) == '}') {
                level--;
                if (level == 0) {
                    String subExpr = expr.substring(start + 1, i);
                    Set<String> subResult = expandGroup(subExpr);
                    String left = expr.substring(0, start);
                    String right = expr.substring(i + 1);
                    for (String sub : subResult) {
                        result.addAll(expand(left + sub + right));
                    }
                    return result;
                }
            }
        }
        
        return result;
    }

    private Set<String> expandGroup(String group) {
        Set<String> result = new HashSet<>();
        int level = 0;
        StringBuilder current = new StringBuilder();
        
        for (int i = 0; i <= group.length(); i++) {
            if (i == group.length() || (group.charAt(i) == ',' && level == 0)) {
                result.addAll(expand(current.toString()));
                current = new StringBuilder();
            } else {
                if (group.charAt(i) == '{') level++;
                if (group.charAt(i) == '}') level--;
                current.append(group.charAt(i));
            }
        }
        
        return result;
    }
}