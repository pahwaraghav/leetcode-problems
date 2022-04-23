class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder(s.length());
        for(int i=strArr.length-1; i>=0;i--){
            if(strArr[i].trim() == "") continue;
            if(i!=0) sb.append(strArr[i] + " ");
            else sb.append(strArr[i]);
        }
        return sb.toString();
    }
}