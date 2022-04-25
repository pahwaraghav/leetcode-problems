class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int curr = 0;
        for(int num: nums){
            if(num == 0) curr =0;
            else curr++;
            ans = Math.max(ans,curr);
        }
        return ans;
    }
}