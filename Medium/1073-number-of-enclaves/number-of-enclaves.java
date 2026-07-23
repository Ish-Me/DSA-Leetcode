class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 || j==0 || i == n-1 || j==m-1){
                    if(vis[i][j] == 0 && grid[i][j] == 1){
                        dfs(i,j,vis,grid,n,m);
                    }
                }
            }
        }
        int cnt=0;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1)cnt++;
            }
        }
        return cnt;
    }
    private void dfs(int i,int j,int[][] vis,int[][] grid,int n,int m){
        vis[i][j] = 1;
        if(i+1<n && j<m && i>=0 && j>=0 && grid[i+1][j] == 1 && vis[i+1][j] == 0)dfs(i+1,j,vis,grid,n,m);
        if(i-1>=0 && j<m && i<n && j>=0 && grid[i-1][j] == 1 && vis[i-1][j] == 0)dfs(i-1,j,vis,grid,n,m);
        if(i<n && j-1>=0 && i>=0 && j<m && grid[i][j-1] == 1 && vis[i][j-1] == 0)dfs(i,j-1,vis,grid,n,m);
        if(i<n && j+1<m && i>=0 && j>=0 && grid[i][j+1] == 1 && vis[i][j+1] == 0)dfs(i,j+1,vis,grid,n,m);
        return;
    }
}