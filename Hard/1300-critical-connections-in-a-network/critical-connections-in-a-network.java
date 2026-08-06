class Solution {
    int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, vis, adj, tin, low, bridges);

        return bridges;
    }

    private void dfs(int node, int parent, boolean[] vis, List<List<Integer>> adj, int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = true;           
        tin[node] = low[node] = timer++; 

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;

            if (!vis[neighbor]) {
                dfs(neighbor, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[neighbor]);

                if (low[neighbor] > tin[node]) {
                    bridges.add(Arrays.asList(neighbor, node));
                }
            } else {
                low[node] = Math.min(low[node], low[neighbor]);
            }
        }
    }
}