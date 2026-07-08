class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int i=0,j=0;
        double x=0,y=0;
        int[] list = new int[m+n];
        int l=0;
        while(i<n && j<m){
            list[l]=nums1[i];
            l++;
            list[l]=nums2[j];
            l++;
            i++;
            j++;
        }
        while(i<n){
            list[l]=nums1[i];
            i++;
            l++;
        }
        while(j<m){
            list[l]=nums2[j];
            j++;
            l++;
        }
        Arrays.sort(list);
        if(list.length%2 != 0)return list[list.length/2];
        else{
            x = list[list.length/2];
            y = list[list.length/2-1];
            return (x+y)/2;
        }
    }

}