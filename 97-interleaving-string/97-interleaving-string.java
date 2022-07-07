class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int[][] dp = new int[101][101];
        for(int[] arr: dp){
            for(int i=0; i<arr.length;i++){
                arr[i] = -1;
            }
        }
        return helper(s1,s2,s3,dp,0,0);
    }
    public boolean helper(String s1, String s2,String s3, int[][] dp, int i1, int i2){
        
        if(i1 >= s1.length() && i2 >= s2.length()){
            return true;
        }
        
        if(dp[i1][i2] != -1){
            if(dp[i1][i2] == 1) return true;
            return false;
        }
        boolean left = false, right = false;
        
        if(i1 < s1.length() && s3.charAt(i1+i2) == s1.charAt(i1)){
            left = helper(s1,s2,s3,dp,i1+1, i2);
        }
        if(i2 < s2.length() && s3.charAt(i1+i2) == s2.charAt(i2)){
            right = helper(s1,s2,s3,dp, i1, i2+1);
        }
        
        dp[i1][i2] = left || right ? 1 : 0;
        
        return left || right;
    }
}