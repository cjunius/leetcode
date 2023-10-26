// https://leetcode.com/problems/merge-sorted-array
class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        mergeReverseIterating(nums1, m, nums2, n);
        //mergeAppendAndSort(nums1, m, nums2, n);
    }

    public void mergeReverseIterating(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m - 1;
        int j = n - 1;

        while(j >= 0) {

            if(i >= 0 && nums1[i] > nums2[j]) {
                nums1[i+j+1] = nums1[i--];
            } else {
                nums1[i+j+1] = nums2[j--];
            }

        }

    }

    public void mergeAppendAndSort(int[] nums1, int m, int[] nums2, int n) {

        for(int i=0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);

    }

}
