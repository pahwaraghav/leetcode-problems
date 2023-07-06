class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(0);
        int ans = nums.length+1;
        for(int i=0; i<=nums.length; i++) {
            if(i!= nums.length) prefix.add(prefix.get(prefix.size()-1) + nums[i]);
            int val = prefix.get(i) - target;
            int idx = lowerBound(prefix, val);
            if(idx == -1) continue;
            ans = Math.min(ans, i - idx);
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
    public int lowerBound(ArrayList<Integer> arr, int target) {
        int low = 0;
        int high = arr.size()-1;
        int ans = -1;
        while(low<=high) {
            int mid = low + (high - low) / 2;
            if(arr.get(mid) <= target) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
}