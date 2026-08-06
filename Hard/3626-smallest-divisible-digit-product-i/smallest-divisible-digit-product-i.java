class Solution {
    public int smallestNumber(int n, int t) {
        int p=1;
        int d=0;
        for(int i=n;i<=100;i++){
            d=i;
            while(d!=0){
                p*=d%10;
                d/=10;
            }
            if(p%t == 0)return i;
            p=1;
        }
        return -1;
    }
}