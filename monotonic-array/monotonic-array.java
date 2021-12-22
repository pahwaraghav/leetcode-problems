class Solution {
    public boolean isMonotonic(int[] nums) {
        int up = 1;
        int down = 1;
        
        for(int i=1; i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                down = 0;
            }
            else if(nums[i] < nums[i-1]){
                up = 0;
            }
        }
        if(up==1 || down == 1) return true;
        return false;
    }
}