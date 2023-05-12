class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp,-1);
        return helper(questions, dp, 0);
    }
    public long helper(int[][] questions, long[] dp, int i){
        if(i>= questions.length) return 0;
        if(dp[i] != -1) return dp[i];
        long solve = questions[i][0] + helper(questions, dp, i+questions[i][1] + 1);
        long notSolve = helper(questions, dp, i+1);
        return dp[i] = Math.max(solve, notSolve);
    }
}