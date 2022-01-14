class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int product = 1;
        
        while(i < s.length() && s.charAt(i) == ' '){i++;}
        
        if(i < s.length() && s.charAt(i) == '-'){
            product = -1;
            i++;
        }
        else if(i < s.length() && s.charAt(i) == '+') i++;
        
        long num = 0;
        
        while(i< s.length()){
            int rem = s.charAt(i) - '0';
            if(rem < 0 || rem > 9){
                i++;
                break;
            }
            if(num * product < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
            }
            else if(num * product > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            num = num * 10 + rem;
            i++;
        }
        
        
        
        num = num * product;
        
        if(num < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else if(num > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        
        
        return (int)num;
    }
}