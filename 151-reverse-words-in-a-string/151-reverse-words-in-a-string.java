class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strArr = s.split(" ");
        System.out.println(Arrays.toString(strArr));
        StringBuilder sb = new StringBuilder();
        for(int i=strArr.length-1; i>=0;i--){
            if(strArr[i].trim() == "") continue;
            sb.append(strArr[i]);
            if(i!=0) sb.append(" ");
        }
        return sb.toString();
    }
}