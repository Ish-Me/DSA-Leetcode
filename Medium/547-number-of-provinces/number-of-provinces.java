class Solution {
    class DisjointSet {
        int[] parent;
        int[] size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        } 
        int findParent(int node) {
            if (parent[node] == node)
                return node;

            return parent[node] = findParent(parent[node]);
        }
        void unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv)
                return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i)
                cnt++;
        }

        return cnt;
    }
}