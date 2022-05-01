class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] c1 = new char[s.length()];
        char[] c2 = new char[t.length()];
        int l1 = 0;
        int l2 = 0;
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '#'){
                l1 = Math.max(l1-1,0);
            }
            else{
                c1[l1] = ch;
                l1++;
            }
        }
        for(int i=0; i<t.length();i++){
            char ch = t.charAt(i);
            if(ch == '#'){
                l2 = Math.max(l2-1,0);
            }
            else{
                c2[l2] = ch;
                l2++;
            }
        }
        if(l1 != l2) return false;
        for(int i=0; i<l1;i++){
            char ch1 = c1[i];
            char ch2 = c2[i];
            if(ch1 != ch2) return false;
        }
        return true;
    }
}