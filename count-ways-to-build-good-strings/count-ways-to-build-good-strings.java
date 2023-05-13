class Solution {
    int MOD = (int)(1e9 + 7);
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp,-1);
        return helper(low, high, zero, one, 0, dp);
    }
    public int helper(int low, int high, int zero, int one, int i, int[] dp) {
        if(i>high) return 0;
        if(dp[i] != -1) return dp[i];
        int flag = 0;
        if(i>=low && i <= high) {
            flag = 1;
        }
        int a = helper(low, high, zero, one, i+zero, dp);
        int b = helper(low, high, zero, one, i+one, dp);
        return dp[i] = (flag + a + b)%MOD;
    }
}