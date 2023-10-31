// https://leetcode.com/problems/single-number
class Solution {
    public int singleNumber(int[] nums) {
        //return singleNumberMap(nums);         //slowest
        //return singleNumberArraySort(nums);   //slow
        return singleNumberXOR(nums);           //fastest
    }

    public int singleNumberMap(int[] nums){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            if(map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, 0);
            }
        }

        return (int) map.keySet().toArray()[0];
    }

    public int singleNumberArraySort(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i+=2) {
            if(nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

     public int singleNumberXOR(int[] nums) {
        int result = 0;
        for(int x : nums){
            result ^= x;
        }
        return result;
    }
}
