class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];

        for (int i = 0;i<n;i++) {
            if (vis[i] == 0) {
                dfs(i, vis, pathVis, graph);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(pathVis[i] == 0){
                list.add(i);
            }
        }
        return list;
    }
    private boolean dfs(int i,int[] vis,int[] pathVis,int[][] graph){
        int n = graph.length;
        vis[i] = 1;
        pathVis[i] = 1;
        for(int x : graph[i]){
            if(vis[x] == 0){
                if(dfs(x,vis,pathVis,graph))return true;
            }
            else if(pathVis[x] == 1)return true;
        }
        pathVis[i] = 0;
        return false;
    }
}