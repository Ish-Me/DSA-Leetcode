class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)adj.add(new ArrayList<>());

        for (int[] i : flights)adj.get(i[0]).add(new int[]{i[1], i[2]});
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0}); 
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int stops = current[0]; 
            int node = current[1];  
            int cost = current[2]; 
           
            if (stops > k)
                continue;
            for (int[] adjNode : adj.get(node)) {
                int nextNode = adjNode[0];  
                int costNext = adjNode[1];  

                if (cost + costNext < dist[nextNode] && stops <= k) {
                    dist[nextNode] = cost + costNext;
                    q.offer(new int[]{stops + 1, nextNode, dist[nextNode]}); 
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE)
            return -1;

        return dist[dst];
    }
}