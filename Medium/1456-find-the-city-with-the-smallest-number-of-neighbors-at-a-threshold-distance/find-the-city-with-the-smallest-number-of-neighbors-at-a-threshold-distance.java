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
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(dist[k][i]==Integer.MAX_VALUE || dist[i][j]==Integer.MAX_VALUE)continue;
                    dist[j][k]=Math.min(dist[j][k],dist[k][i]+dist[i][j]);
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