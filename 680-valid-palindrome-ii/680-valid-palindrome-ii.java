class Solution {
    public boolean validPalindrome(String s) {
        return helper(s,0,s.length()-1,false);
    }
    public static boolean helper(String s, int l, int r, boolean flag){
        if(l>r){
            return true;
        }
        if(s.charAt(l) == s.charAt(r)){
            return helper(s,l+1,r-1,flag);
        }
        else if(flag == true){
            return false;
        }
        else{
            return helper(s,l,r-1,true) || helper(s,l+1,r,true);
        }
    }
}