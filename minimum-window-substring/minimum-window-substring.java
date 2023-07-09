class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        int[] freq1 = new int[256];
        for(int i=0; i<t.length(); i++) {
            freq1[t.charAt(i) - 'A']++;
        }
        int[] freq2 = new int[256];
        int left = 0;
        int right = 0;
        while(right<s.length()) {
            boolean res = check(freq1, freq2);
            if(res) {
                if(ans.equals("") || right - left < ans.length()) {
                    ans = s.substring(left, right);
                }
                freq2[s.charAt(left)-'A']--;
                left++;
            }
            else {
                freq2[s.charAt(right) - 'A']++;
                right++;
            }
        }
        while(check(freq1, freq2)) {
            if(ans.equals("") || right - left < ans.length()) {
                ans = s.substring(left, right);
            }
            freq2[s.charAt(left)-'A']--;
            left++;
        }
        return ans;
    }
    private boolean check(int[] freq1, int[] freq2){
        for(int i=0; i<freq1.length; i++){
            if(freq2[i] < freq1[i]){
                return false;
            }
        }
        return true;
    }
}