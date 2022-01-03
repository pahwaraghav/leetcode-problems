class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0,prev = 0,current =1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                current++;
            }
            else{
                res += Math.min(prev,current);
                prev = current;
                current = 1;
            }
        }
        return res + Math.min(prev,current);
    }
}