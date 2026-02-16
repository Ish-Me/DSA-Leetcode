class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int nge[] = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 2*nums.length-1;i>=0;i--){
            int index = i%nums.length;
            while(!st.isEmpty() && st.peek()<=nums[index]){
                st.pop();
            }
            if(st.isEmpty())nge[index]=-1;
            else nge[index]=st.peek();
            st.push(nums[index]);
        }
        return nge;
    }
}