class Solution {
    public boolean isSubsequence(String s, String t) {
        int sStartingAt = 0;
        int matched = 0;
        for(int i=0; i<t.length();i++){
            if(sStartingAt >= s.length() || matched == s.length()){
                break;
            }
            if(t.charAt(i) == s.charAt(sStartingAt)){
                sStartingAt++;
                matched++;
            }
        }
        if(matched == s.length()) return true;
        return false;
    }
}