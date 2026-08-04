class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        int min = nums[0];
        for(int i=min;i<=max;i++){
            list.add(i);
        }
        for(int i=0;i<nums.length;i++){
           if(list.contains(nums[i]))list.remove(Integer.valueOf(nums[i]));
        }
        return list;
    }
}