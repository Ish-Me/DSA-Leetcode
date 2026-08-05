class DSU{
    int[] parent;
    int[] size;

    DSU(int n) {
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
class Solution {
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(20003);
        for (int[] stone : stones) {
            dsu.unionBySize(stone[0], stone[1] + 10001);
        }

        Set<Integer> components = new HashSet<>();

        for (int[] stone : stones) {
            components.add(dsu.findParent(stone[0]));
        }

        return stones.length - components.size();
    }
}