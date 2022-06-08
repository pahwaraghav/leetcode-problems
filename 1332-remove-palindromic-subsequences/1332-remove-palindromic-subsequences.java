class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        StringBuilder sbr = new StringBuilder(s);
        String sRev = sbr.reverse().toString();
        if(s.equals(sRev)) return 1;
        return 2;
    }
}