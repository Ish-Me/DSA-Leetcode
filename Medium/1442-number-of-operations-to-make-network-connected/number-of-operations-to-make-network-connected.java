class Solution {
    class DisjointSet{
        int[] parent;
        int[] size;

        DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        int findParent(int node){
            if(parent[node] == node)return node;
            return parent[node] = findParent(parent[node]);
        }
        void unionBySize(int u,int v){
            int ult_u=findParent(u);
            int ult_v=findParent(v);
            if(ult_u == ult_v)return;
            if(size[ult_u]>size[ult_v]){
                parent[ult_v]=ult_u;
                size[ult_u]+=size[ult_v];
            }
            else{
                parent[ult_u]=ult_v;
                size[ult_v]+=size[ult_u];
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        
        DisjointSet ds = new DisjointSet(n);
        if(connections.length < n-1)return -1;
        for (int i = 0; i < connections.length; i++) {
                ds.unionBySize(connections[i][0], connections[i][1]);
            }
        int cmp = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i)
                cmp++;
        }

        return cmp-1;
    }
}