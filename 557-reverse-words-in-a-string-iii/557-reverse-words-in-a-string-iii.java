class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(j<s.length()){
            if(s.charAt(j) != ' '){
                j++;
                continue;
            }
            else{
              reverse(s,sb,i,j-1);
                sb.append(" ");
                j++;
                i = j;
            }
        }
        reverse(s,sb,i,s.length()-1);
        return sb.toString();
    }
    public void reverse(String s, StringBuilder sb, int start, int end){
        for(int i=end; i>=start;i--){
            sb.append(s.charAt(i)+"");  
        }
    }
}