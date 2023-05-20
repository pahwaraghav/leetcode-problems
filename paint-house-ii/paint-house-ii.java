class Solution {
    public int minCostII(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length+1];
        return helper(costs, dp, 0, 0);
    }
    public int helper(int[][] costs, int[][]dp, int i, int prev) {
        if(i==costs.length){
            return 0;
        }
        if(dp[i][prev] != 0){
            return dp[i][prev];
        }
        int min = (int)(1e9+7);
        for(int k=0; k<costs[0].length; k++){
            if(k == prev-1) continue;
            int val = costs[i][k] + helper(costs, dp, i+1, k+1);
            min = Math.min(min,val);
        }
        return dp[i][prev] =  min;
    }
}