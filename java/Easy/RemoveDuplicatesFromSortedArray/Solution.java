//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len <= 1) return len;

        int idx = 1;
        for(int n : nums) {
            if(n > nums[idx-1]) {
                nums[idx++] = n;
            }
        }
        return idx;
    }
}
