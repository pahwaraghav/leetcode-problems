class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {lowerBound(nums,target), upperBound(nums,target)};
        return res;
    }
    public int lowerBound(int[]nums, int target){
        int low = 0;
        int high = nums.length-1;
        int res = -1;
        while(low <= high){
            int mid = (low + high) /2;
            if(nums[mid] >= target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
            if(nums[mid] == target) res = mid;
        }
        return res;
    }
    public int upperBound(int[]nums, int target){
        int low = 0;
        int high = nums.length-1;
        int res = -1;
        while(low <= high){
            int mid = (low + high) /2;
            if(nums[mid] <= target){
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
            if(nums[mid] == target) res = mid;
        }
        return res;
    }
}