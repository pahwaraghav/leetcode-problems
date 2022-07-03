class Solution {
    public int wiggleMaxLength(int[] nums) {
        int ans = 1;
        int prevDiff = 0;
        int currDiff = 0;
        for(int i=1; i<nums.length; i++){
            currDiff = nums[i] - nums[i-1];
            if((prevDiff <=0 && currDiff > 0) || (prevDiff >=0 && currDiff < 0)){
                ans++;
                prevDiff = currDiff;
            }
        }
        return ans;
    }
}