class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        
        while(right <s.length()){
            char ch = s.charAt(right);
            if(hmap.containsKey(ch)){
                left = Math.max(left, hmap.get(ch) + 1);
            }
            hmap.put(ch,right);
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }
}