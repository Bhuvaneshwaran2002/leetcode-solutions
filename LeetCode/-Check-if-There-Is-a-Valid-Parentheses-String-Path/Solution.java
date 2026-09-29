class Solution {

    HashMap<String,Boolean> dpMap;

    public boolean solve(char[][] grid , int i , int j , int m , int n , int open){
        if(open < 0){
            return false;
        }
        if(i == m-1 && j == n-1){
            open += (grid[i][j] == '(' ? 1 : -1);
            return open == 0;
        }
        
        open += (grid[i][j] == '(' ? 1 : -1);
        String key = i+"$"+j+"$"+open;
        if(dpMap.containsKey(key)){
            return dpMap.get(key);
        }
        // going down 
        if(i+1 < m){
            boolean down = solve(grid , i+1 , j , m , n , open);
            if(down){
                dpMap.put(key , true);
                return true;
            }
        }
        //going right
        if(j+1 < n){
            boolean right = solve(grid , i , j+1 , m , n, open);
            if(right){
                dpMap.put(key , true);
                return true;
            }
        }
        dpMap.put(key , false);
        return false;

    }
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dpMap = new HashMap<>();
        return solve(grid , 0 , 0 , m , n , 0);
    }
}