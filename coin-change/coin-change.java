class Solution {
    long max = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        System.out.println(Arrays.toString(coins));
        long[][] dp = new long[amount+1][coins.length+1];
        long ans = helper(coins, amount, coins.length-1, dp);
        if(ans >= max) return -1;
        else return (int) ans;
    }
    public long helper(int[] coins, int amount, int i, long[][] dp) {
        if(i<0) return max;
        if(amount == 0) return 0;
        //System.out.println(i + " " + amount);
        if(dp[amount][i] != 0) return dp[amount][i];
        long take = max, notTake = max;
        if(coins[i] <= amount) take = 1 + helper(coins, amount-coins[i], i, dp);
        notTake = helper(coins, amount, i-1, dp);
        return dp[amount][i] = Math.min(take, notTake);
    }
}