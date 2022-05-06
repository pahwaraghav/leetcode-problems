class Solution {
    public String removeDuplicates(String s, int k) {
        char[] res = s.toCharArray();
        int count[] = new int[s.length()];
        int i = 0;
        for(int j=0; j<s.length();j++,i++){
            res[i] = res[j];
            count[i] = i > 0 && res[i - 1] == res[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
        }
        return new String(res,0,i);
    }
}