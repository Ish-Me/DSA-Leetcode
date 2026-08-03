class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][] dist = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for(int[] edge : edges){
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][via]==Integer.MAX_VALUE || dist[via][j]==Integer.MAX_VALUE)continue;
                    dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                }
            }
        }
        int cntCity = n;
        int cityNum = -1;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold)cnt++;
            }
            if(cnt<=cntCity){
                cntCity = cnt;
                cityNum = i;
            }
        }
        return cityNum;
    }
}