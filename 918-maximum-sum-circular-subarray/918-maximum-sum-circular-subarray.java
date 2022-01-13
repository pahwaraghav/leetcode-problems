class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSumNonCircular = nums[0];
        int currentSumNonCircular = nums[0];
        
        int sum =nums[0];
        
        int minSum = nums[0];
        int currentMinSum = nums[0];
        
        for(int i=1; i<nums.length;i++){
            sum += nums[i];
            
            currentSumNonCircular = Math.max(currentSumNonCircular+nums[i],nums[i]);
            maxSumNonCircular = Math.max(maxSumNonCircular,currentSumNonCircular);
            
            currentMinSum = Math.min(currentMinSum + nums[i], nums[i]);
            minSum = Math.min(minSum, currentMinSum);
        }

        
        if(sum == minSum) return maxSumNonCircular;
        return Math.max(maxSumNonCircular, sum - minSum);
    }
}