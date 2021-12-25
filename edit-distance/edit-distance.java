class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        dp[0][0] = 0;
        for(int i=0;i<=word2.length();i++){
            dp[0][i] = i;
        }
        for(int i=1; i<=word1.length();i++){
            dp[i][0] = dp[i-1][0] + 1;
            for(int j=1; j<=word2.length();j++){
                if(word2.charAt(j-1) == word1.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];   
                }
                else{
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}