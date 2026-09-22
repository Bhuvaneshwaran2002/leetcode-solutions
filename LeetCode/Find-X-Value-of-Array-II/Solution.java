1class Solution {
2    private class Node {
3        int[] cnt;
4        int prod;
5        Node(int k) {
6            cnt = new int[k];
7            prod = 1;
8        }
9    }
10    private class SegTree {
11        int k, n, s;
12        Node[] tree;
13        SegTree(int[] nums, int k) {
14            this.k = k;
15            this.n = nums.length;
16            this.s = 1;
17            while (s < n) s <<= 1;
18            tree = new Node[2 * s];
19            for (int i = 0; i < 2 * s; i++) {
20                tree[i] = new Node(k);
21            }
22            for (int i = 0; i < n; i++) {
23                int a_mod = nums[i] % k;
24                tree[s + i].cnt[a_mod] = 1;
25                tree[s + i].prod = a_mod;
26            }
27            for (int p = s - 1; p > 0; p--) {
28                tree[p] = merge(tree[2 * p], tree[2 * p + 1]);
29            }
30        }
31        Node merge(Node l, Node r) {
32            Node res = new Node(k);
33            for (int i = 0; i < k; i++) res.cnt[i] = l.cnt[i];
34            for (int r_b = 0; r_b < k; r_b++) {
35                int c = r.cnt[r_b];
36                if (c != 0) {
37                    int r_ = (l.prod * r_b) % k;
38                    res.cnt[r_] += c;
39                }
40            }
41            res.prod = (l.prod * r.prod) % k;
42            return res;
43        }
44        void update(int idx, int val) {
45            int pos = s + idx;
46            int a_mod = val % k;
47            Arrays.fill(tree[pos].cnt, 0);
48            tree[pos].cnt[a_mod] = 1;
49            tree[pos].prod = a_mod;
50            pos >>= 1;
51            while (pos > 0) {
52                tree[pos] = merge(tree[2 * pos], tree[2 * pos + 1]);
53                pos >>= 1;
54            }
55        }
56        Node query(int l, int r) {
57            Node cnt_l = new Node(k);
58            Node cnt_r = new Node(k);
59            cnt_l.prod = cnt_r.prod = 1;
60            l += s;
61            r += s;
62            while (l < r) {
63                if ((l & 1) == 1) {
64                    cnt_l = merge(cnt_l, tree[l++]);
65                }
66                if ((r & 1) == 1) {
67                    cnt_r = merge(tree[--r], cnt_r);
68                }
69                l >>= 1;
70                r >>= 1;
71            }
72            return merge(cnt_l, cnt_r);
73        }
74    }
75    public int[] resultArray(int[] nums, int k, int[][] queries) {
76        SegTree st = new SegTree(nums, k);
77        int[] res = new int[queries.length];
78        for (int i = 0; i < queries.length; i++) {
79            int idx = queries[i][0];
80            int val = queries[i][1];
81            int start = queries[i][2];
82            int x = queries[i][3];
83            st.update(idx, val);
84            Node result = st.query(start, nums.length);
85            res[i] = result.cnt[x];
86        }
87        return res;
88    }
89}