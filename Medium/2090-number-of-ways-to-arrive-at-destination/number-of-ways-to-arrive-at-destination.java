class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads){
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];
        dist[0] = 0;
        ways[0] = 1;

        pq.add(new long[]{0, 0});  
        int mod = (int)(1e9 + 7);

        while (!pq.isEmpty()){
            long[] current = pq.poll();
            long dis = current[0];
            int node = (int)current[1];

            if(dis > dist[node])continue;

            for (int[] neighbor : adj.get(node)){
                int adjNode = neighbor[0]; 
                int nextW = neighbor[1];  

                if (dis + nextW < dist[adjNode]){
                    dist[adjNode] = dis + nextW;
                    ways[adjNode] = ways[node];
                    pq.add(new long[]{dist[adjNode], adjNode});  
                }
                else if (dis + nextW == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node])%mod;  
                }
            }
        }
        return ways[n-1];
    }
}