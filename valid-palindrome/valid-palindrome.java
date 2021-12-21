class Solution {
    public boolean isPalindrome(String s) {
        int startPos = 0;
        int endPos = s.length() -1;
        
        while(startPos <= endPos){
            while(startPos <= endPos && !Character.isLetterOrDigit(s.charAt(startPos))){
                startPos++;
            }
            while(startPos <= endPos && !Character.isLetterOrDigit(s.charAt(endPos))){
                endPos--;
            }
            
            if(startPos <= endPos && Character.toLowerCase(s.charAt(startPos)) != Character.toLowerCase(s.charAt(endPos))){
                return false;
            }
            startPos++;
            endPos--;
        }
        return true;
    }
    
}