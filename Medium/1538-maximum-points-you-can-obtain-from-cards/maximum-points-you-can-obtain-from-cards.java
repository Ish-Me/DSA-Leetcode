class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0,rsum=0,maxSum=0;
        for(int i=0;i<k;i++)lsum=lsum+cardPoints[i];
        maxSum=lsum;
        int rind=cardPoints.length-1;
        for(int j=k-1;j>=0;j--){
            lsum=lsum-cardPoints[j];
            rsum=rsum+cardPoints[rind];
            rind--;
            maxSum=Math.max(maxSum,rsum+lsum);
        }
        return maxSum;
    }
}