class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int count = 0;
        int[] vis = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                count++;
                bfs(i, vis, isConnected);
            }
        }
        return count;
    }
    public static void bfs(int node, int[] vis, int[][] isConnected) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        vis[node] = 1;
        while (!queue.isEmpty()) {
            Integer startingNode = queue.poll();
            for (int i=0;i<isConnected.length;i++) {
                if (isConnected[startingNode][i]==1 && vis[i]==0) {
                    vis[i] = 1;
                    queue.add(i);
                }
            }
        }

    }
}