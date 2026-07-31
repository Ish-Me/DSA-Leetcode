class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)return -1;

        int n = grid.length;
        int m = grid[0].length;

        if(n==1 && m==1 && grid[0][0] == 0)return 1;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0, 0});  
        int[] dr = {-1, 0, 1, 0, 1, -1, 1, -1};
        int[] dc = {0, 1, 0, -1, 1, -1, -1, 1};
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int dis = current[0];
            int r = current[1];
            int c = current[2];

            for (int i = 0; i < 8; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];
                if (newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 0 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = dis + 1;  
                if (newr == n-1 && newc == m-1)
                    return dis + 1;
                q.offer(new int[]{dis + 1, newr, newc});
                }
            }
        }
        return -1;
    }
}