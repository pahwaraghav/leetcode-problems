class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        int left = 0;
        int right = 1;
        int ans = 1;
        hmap.put(s.charAt(0),1);
        while(right <s.length()) {
            if(hmap.size() <= k){
                ans = Math.max(ans, right-left);
                hmap.put(s.charAt(right), hmap.getOrDefault(s.charAt(right),0)+1);
                right++;
            }
            else {
                hmap.put(s.charAt(left), hmap.getOrDefault(s.charAt(left),1)-1);
                if(hmap.get(s.charAt(left)) == 0){
                    hmap.remove(s.charAt(left));
                }

                left++;
            }
        }
        if(hmap.size() <= k){
            ans = Math.max(ans, right-left);
        }
        return ans;
    }
}