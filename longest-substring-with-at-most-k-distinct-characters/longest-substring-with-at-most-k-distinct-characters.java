class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        int[] freq = new int[256];
        int left = 0;
        int right = 1;
        int ans = 1;
        freq[s.charAt(0)]++;
        while(right <s.length()) {
            if(count(freq) <= k){
                ans = Math.max(ans, right-left);
                freq[s.charAt(right)]++;
                right++;
            }
            else {
                freq[s.charAt(left)]--;
                left++;
            }
        }
        if(count(freq) <=k){
            ans = Math.max(ans, right-left);
        }
        return ans;
    }
    public int count(int[] freq){
        int res = 0;
        for(int val: freq){
            if(val != 0) res++;
        }
        return res;
    }
}