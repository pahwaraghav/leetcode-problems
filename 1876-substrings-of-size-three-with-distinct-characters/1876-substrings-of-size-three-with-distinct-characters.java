class Solution {
    public int countGoodSubstrings(String s) {
        int left = 2;
        int res = 0;
        if(s.length() <2) return 0;
        while(left < s.length()){
            if(s.charAt(left) == s.charAt(left-1) || s.charAt(left-1) == s.charAt(left-2) || s.charAt(left) == s.charAt(left-2)){
                left++;
            }
            else{
                res++;
                left++;
            }
        }
        return res;
    }
}