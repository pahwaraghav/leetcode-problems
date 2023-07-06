class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] prefix = new int[nums.length+1];
        prefix[0] = 0;
        for(int i=0; i<nums.length; i++){
            if(i==0) prefix[i+1] = nums[i];
            else prefix[i+1] = prefix[i] + nums[i];
        }
        int ans = nums.length+1;
        for(int i=0; i<prefix.length; i++) {
            int val = prefix[i] - target;
            int idx = lowerBound(prefix, val);
            if(idx == -1) continue;
            ans = Math.min(ans, i - idx);
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
    public int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] <= target) {
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