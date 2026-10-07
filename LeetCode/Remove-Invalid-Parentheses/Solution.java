class Solution {
    List<String> res;
    char[] arr;
    int p;
    int max;
    
    public List<String> removeInvalidParentheses(String s) {
        res = new ArrayList<>();
        arr = new char[s.length()];
        Set<Node> set = new HashSet<>();
        Node root = new Node(0);
        set.add(root);
        for (char ch : s.toCharArray()) {
            Set<Node> add = new HashSet<>();
            for (Node i : set) {
                add.add(i.add(ch));
            }
            set.addAll(add);
        }
        explore(root, 0);
        return res;
    }
    
    void explore(Node n, int depth) {
        if (n.cnt == 0) {
            if (depth > max) {
                max = depth;
                res = new ArrayList<>();
            }
            if (depth == max)
                res.add(new String(arr, 0, p));
        }
        Node[] nxt = n.next;
        for (int i = 0; i < 28; i++) {
            if (nxt[i] == null) continue;
            arr[p++] = getChar(i);
            explore(nxt[i], depth + 1);
            p--;
        }
    }
    
    char getChar(int ind) {
        return ind == 26 ? '(' : ind == 27 ? ')' : (char) (ind + 'a');
    }
    

    public static class Node {
        Node[] next;
        int cnt;

        public Node(int cnt) {
            next = new Node[28];
            this.cnt = cnt;
        }

        Node add(char ch) {
            int ind = getInd(ch);
            if (next[ind] == null) {
                int newCnt = cnt + cnt(ch);
                if (newCnt < 0) return this;
                next[ind] = new Node(newCnt);
            }
            return next[ind];
        }

        Node get(char ch) {
            return next[getInd(ch)];
        }


        int getInd(char ch) {
            if (ch == '(') return 26;
            else if (ch == ')') return 27;
            return ch - 'a';
        }
        
        int cnt(char ch) {
            if (ch == '(') return 1;
            else if (ch == ')') return -1;
            return 0;
        }
    }
}