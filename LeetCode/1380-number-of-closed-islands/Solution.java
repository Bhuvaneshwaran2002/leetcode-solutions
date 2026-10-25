class Solution {
    void backtrack(int[][]grid,int row,int col,int n,int m){
        if(row<0 || row>=n || col<0 ||col>=m||grid[row][col]==1) return;
        grid[row][col]=1;
        backtrack(grid,row+1,col,n,m);
        backtrack(grid,row-1,col,n,m);
        backtrack(grid,row,col+1,n,m);
        backtrack(grid,row,col-1,n,m);
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==0){
                backtrack(grid,i,0,n,m);
            }
            if(grid[i][m-1]==0){   
                backtrack(grid,i,m-1,n,m);
            }
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==0){
                backtrack(grid,0,j,n,m);
            }
            if(grid[n-1][j]==0){
                backtrack(grid,n-1,j,n,m);
            }
        }
        int count=0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j]==0){
                    count++;
                    backtrack(grid,i,j,n,m);
                }
            }
        }
        return count;
    }
}