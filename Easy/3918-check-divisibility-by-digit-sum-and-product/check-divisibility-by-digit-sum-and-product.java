class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,prod=1,d=0;
        d=n;
        while(d!=0){
            sum+=d%10;
            prod*=d%10;
            d/=10;
        }
        if(n%(sum+prod) == 0)return true;
        return false;

    }
}