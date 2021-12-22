class Solution {
    public boolean isMonotonic(int[] nums) {
        int up = 1;
        int down = 1;
        
        if(nums.length<=2) return true;
        
        for(int i=1; i<nums.length;i++){
            if(up==0 && down ==0) return false;
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