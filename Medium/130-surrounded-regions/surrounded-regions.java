class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        for(int i = 0;i < n;i++){
            if(vis[i][0] == 0 && board[i][0] == 'O')dfs(i,0,vis,board);
            if(vis[i][m-1] == 0 && board[i][m-1] == 'O')dfs(i,m-1,vis,board);
        }
        for(int j = 0;j < m;j++){
            if(vis[0][j] == 0 && board[0][j] == 'O')dfs(0,j,vis,board);
            if(vis[n-1][j] == 0 && board[n-1][j] == 'O')dfs(n-1,j,vis,board);
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == 'O' && vis[i][j] == 0)board[i][j] = 'X';
            }
        }

    }
    private void dfs(int i,int j,int[][] vis,char[][] board){
        int n = board.length;
        int m = board[0].length;

        if(i<0 || i>n-1 || j>m-1 || j<0 || vis[i][j] == 1 || board[i][j] == 'X')return;

        vis[i][j] = 1;

        dfs(i+1,j,vis,board);
        dfs(i-1,j,vis,board);
        dfs(i,j+1,vis,board);
        dfs(i,j-1,vis,board);
    }
}