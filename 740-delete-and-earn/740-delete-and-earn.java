class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        
        int[] buckets = new int[n];
        for(int num : nums){
            buckets[num] += num;
        }
        int[] dp = new int[n];
        dp[0] = buckets[0];
        dp[1] = buckets[1];
        for(int i=2; i<n;i++){
            dp[i] = Math.max(buckets[i] + dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
}