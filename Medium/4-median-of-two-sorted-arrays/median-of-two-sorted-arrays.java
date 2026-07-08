class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int i=0,j=0;
        double x=0,y=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<n && j<m){
            list.add(nums1[i]);
            list.add(nums2[j]);
            i++;
            j++;
        }
        while(i<n){
            list.add(nums1[i]);
            i++;
        }
        while(j<m){
            list.add(nums2[j]);
            j++;
        }
        Collections.sort(list);
        if(list.size()%2 != 0)return list.get(list.size()/2);
        else{
            x = list.get(list.size()/2);
            y = list.get(list.size()/2-1);
            return (x+y)/2;
        }
    }

}