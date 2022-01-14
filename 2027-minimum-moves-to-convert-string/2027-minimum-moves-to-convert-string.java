class Solution {
    public int minimumMoves(String s) {
        int i = 0;
        int j = 2;
        int count = 0;
        while(j < s.length()){
            if(s.charAt(i) == 'X'){
                i = j+1;
                j = i +2;
                count++;
                continue;
            }
            else{
                i++;j++;
            }
        }
        for(int k = i; k<s.length();k++){
            if(s.charAt(k) == 'X'){
                count++;
                break;
            }
        }
        return count;
    }
}