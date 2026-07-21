class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial = image[sr][sc];
        int[][] ans = image;
        dfs(image,ans,sr,sc,color,initial);
        return ans;
    }
    private void dfs(int[][] image,int[][] ans,int i,int j,int color,int initial){
        ans[i][j] = color;
        int n = image.length;
        int m = image[0].length;
        if(i+1 < n && i+1 >= 0 && ans[i+1][j] != color && ans[i+1][j] == initial)dfs(image,ans,i+1,j,color,initial);
        if(i-1 < n && i-1 >= 0 && ans[i-1][j] != color && ans[i-1][j] == initial)dfs(image,ans,i-1,j,color,initial);
        if(j+1 < m && j+1 >= 0 && ans[i][j+1] != color && ans[i][j+1] == initial)dfs(image,ans,i,j+1,color,initial);
        if(i-1 < m && j-1 >= 0 && ans[i][j-1] != color && ans[i][j-1] == initial)dfs(image,ans,i,j-1,color,initial);
    }
}