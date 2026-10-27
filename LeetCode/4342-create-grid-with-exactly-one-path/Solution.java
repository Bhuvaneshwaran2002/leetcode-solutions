class Solution {
    public String[] createGrid(int m, int n) {
        String str[]=new String[m];
        for(int i=0;i<m;i++)
        {
            StringBuffer sb=new StringBuffer("");
            for(int j=0;j<n;j++)
            {
                if(j==0 || i==m-1)
                {
                    sb.append(".");
                }
                else
                {
                    sb.append("#");
                }
            }
            str[i]=new String(sb);
        }

        return str;
    }
}