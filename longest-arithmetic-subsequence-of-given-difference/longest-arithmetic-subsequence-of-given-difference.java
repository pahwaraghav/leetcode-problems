class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            int org = arr[i];
            int target = org - difference;
            int curr = 1;
            if(hmap.containsKey(target)) {
                curr += hmap.get(target);
            }
            hmap.put(org, curr);
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}