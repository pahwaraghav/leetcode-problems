class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s.length());
        int i=0;
        boolean flag = true;
        while(i<s.length()){
            if(!flag){
                int end = Math.min(i+k, s.length());
                sb.append(s.substring(i,end));
                i+=k;
            }
            else{
                int j = Math.min(s.length() -1, i+k-1);
                for(; j>=i; j--){
                    sb.append(s.charAt(j)+"");
                }
                i+=k;
            }
            flag = !flag;
        }
        return sb.toString();
    }
}