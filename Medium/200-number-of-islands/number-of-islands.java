class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }
    public static void bfs(int row, int col, boolean[][] vis, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        vis[row][col] = true;
        //for traversing in all 4 directions
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int i = 0; i < 4; i++) {
                //Checking for neighbour '1' in all four directions
                int newRow = r + dRow[i];
                int newCol = c + dCol[i];
                if (newRow >= 0 && newRow < m && //Checking boundaries and visited conditions
                    newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == '1' &&
                    !vis[newRow][newCol]) {
                    vis[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
    }
    }
}
