class Solution {
    public int numIslands(char[][] grid) {
       int rows = grid.length;
       int cols = grid[0].length;
       int cnt = 0;
       for(int i = 0; i<rows; i++){
           for(int j = 0; j<cols; j++){
            if(grid[i][j] == '1'){
                cnt++;
                dfs(i, j, grid, rows, cols);
                }
            }
        }
       return cnt;
    }
    private void dfs(int row, int col, char[][]grid, int rows, int cols){
        grid[row][col] = '*';
        if(row-1 > -1 && grid[row - 1][col] == '1') dfs(row - 1, col, grid, rows, cols);
        if(row + 1 < rows && grid[row + 1][col] == '1') dfs(row + 1, col, grid, rows, cols);
        if(col - 1 > -1 && grid[row][col - 1] == '1') dfs(row, col - 1, grid, rows, cols);
        if(col + 1 < cols && grid[row][col+1] == '1') dfs(row, col + 1, grid, rows ,cols);
    }
}