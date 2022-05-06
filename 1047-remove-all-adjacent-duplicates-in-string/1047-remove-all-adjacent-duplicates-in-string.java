class Solution {
    public String removeDuplicates(String s) {
        char[] res = s.toCharArray();
        int i = 0;
        for(int j=0; j<s.length(); i++,j++){
            res[i] = res[j];
            if(i> 0 && res[i-1] == res[i]){
                i-=2;
            }
        }
        return new String(res,0,i);
    }
}