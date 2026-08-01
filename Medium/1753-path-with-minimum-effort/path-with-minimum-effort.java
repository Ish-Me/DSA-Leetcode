class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});  
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int diff = current[0];
            int r = current[1];
            int c = current[2];

            if(r == n-1 && c == m-1)return diff;

            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];
                if (newr >= 0 && newr < n && newc >= 0 && newc < m) {
                    int newEff = Math.max(Math.abs(heights[r][c]-heights[newr][newc]),diff);  
                    if (newEff < dist[newr][newc]){
                        dist[newr][newc] = newEff;
                        pq.offer(new int[]{newEff, newr, newc});
                    }
                }
            }
        }
        return 0;
    }
}