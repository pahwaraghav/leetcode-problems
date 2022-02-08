class Solution {
    public int missingNumber(int[] nums) {
        int orgXor = 0;
        int givenXor = 0;
        for(int i=0; i<nums.length;i++){
            orgXor ^= i;
            givenXor ^= nums[i];
        }
        orgXor ^= nums.length;
        return givenXor ^ orgXor;
    }
}