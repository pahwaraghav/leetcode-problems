class Solution {
    public boolean isPalindrome(String s) {
        String s1 = "";
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                s1+= Character.toLowerCase(ch);
            }
        }
        for(int i=0; i<s1.length()/2; i++){
            if(s1.charAt(i) != s1.charAt(s1.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}