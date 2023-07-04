class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0; i<32; i++) {
            int bitSum = 0;
            for(int num: nums) {
                bitSum += (num >> i) & 1;
            }
            int ansBit = bitSum % 3;
            ans = ans | (ansBit << i);
        }
        return ans;
    }
}