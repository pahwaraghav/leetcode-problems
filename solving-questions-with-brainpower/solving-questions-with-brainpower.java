class Solution {
    public long mostPoints(int[][] questions) {
        long maxVal = 0;
        long[] dp = new long[questions.length];
        for(int i=questions.length -1; i >=0 ;i--){
            long nextScore = 0;
            if(i + questions[i][1] + 1 < questions.length){
                nextScore = dp[i + questions[i][1] + 1];
            }
            dp[i] = Math.max(maxVal, questions[i][0] + nextScore);
           
            maxVal = Math.max(maxVal, dp[i]);
        }
        return dp[0];
    }
}