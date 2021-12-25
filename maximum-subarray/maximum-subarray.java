class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSumEndingHere = nums[0];
        
        for(int i=1; i<nums.length; i++){
            currentSumEndingHere = Math.max(currentSumEndingHere + nums[i],nums[i]);
            
            maxSum = Math.max(maxSum,currentSumEndingHere);
        }
        return maxSum;
    }
}