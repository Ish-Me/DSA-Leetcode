class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        int ans1 = robEx(nums, 0, nums.length - 2);
        int ans2 = robEx(nums, 1, nums.length - 1);
        return Math.max(ans1,ans2);
    }
    public int robEx(int[] nums,int start,int end) {
        int prev = 0;
        int prev2 = 0;
        for(int i=start;i<=end;i++){
            int take = nums[i];
            if(i>1)take+=prev2;
            int notTake = prev;
            int curri = Math.max(take,notTake);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}