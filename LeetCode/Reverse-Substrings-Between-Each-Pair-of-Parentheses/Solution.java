1class Solution {
2    public String reverseParentheses(String s) {
3        StringBuilder sb=new StringBuilder();
4        char[] a=s.toCharArray();
5        boolean flag=true;
6        Stack<Integer> st=new Stack<>();
7        for(int i=0;i<s.length();i++)
8        {
9            if(a[i]=='(')
10            {
11                st.add(i);
12            }
13            else if(a[i]==')')
14            {
15                int left=st.pop();
16                int right=i;
17                left++;
18                right--;
19                while(left<right)
20                {
21                    char c=a[left];
22                    a[left]=a[right];
23                    a[right]=c;
24                    left++;
25                    right--;
26                }
27                System.out.println(new String(a));
28            }
29        }
30        for(int i=0;i<a.length;i++)
31        {
32            if(a[i]!='(' && a[i]!=')')
33            {
34                sb.append(a[i]);
35            }
36        }
37        return sb.toString();
38    }
39}