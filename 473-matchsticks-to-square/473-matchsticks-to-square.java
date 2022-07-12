class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int val : matchsticks){
            sum += val;
        }
        if(matchsticks.length < 4 || sum % 4 != 0) return false;
        Arrays.sort(matchsticks);
        return helper(matchsticks, sum/4, 0,0,0,0,matchsticks.length-1);
    }
    
    public boolean helper(int[] matchsticks, int side, int s1, int s2, int s3, int s4, int i){
        if(s1 > side || s2 > side || s3 > side || s4 > side) return false;
        if(i < 0){
            return s1 == s2 && s2 == s3 && s3 == s4;
        }
        boolean r1 = helper(matchsticks,side, s1+matchsticks[i],s2,s3,s4, i-1);
        boolean r2 = helper(matchsticks,side, s1,s2+matchsticks[i],s3,s4, i-1);
        boolean r3 = helper(matchsticks,side, s1,s2,s3+matchsticks[i],s4, i-1);
        boolean r4 = helper(matchsticks,side, s1,s2,s3,s4+matchsticks[i], i-1);
        
        return r1 || r2 || r3 || r4;
    }
}