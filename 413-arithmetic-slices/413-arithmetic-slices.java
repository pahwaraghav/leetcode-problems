class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int res = 0;
        
        int start = 0;
        
        for(int i=2; i<nums.length; i++){
            if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]){
                res += i - start -1;
            }
            else{
                start = i-1;
            }
        }
        return res;
    }
}