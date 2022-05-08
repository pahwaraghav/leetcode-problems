class Solution {
    public int minimumDeletions(String s) {
        int[] dp = new int[s.length()+1];
        int bCount = 0;
        for(int i=1; i<=s.length();i++){
            char ch = s.charAt(i-1);
            if(ch == 'a'){
                dp[i] = Math.min(dp[i-1]+1,bCount);
            }
            else{
                bCount++;
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }
}