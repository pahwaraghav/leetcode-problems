class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            while(nums[i] >0 && nums[i] < nums.length && nums[i]-1 !=i){
                if(nums[i] == nums[nums[i]-1]){
                    break;
                }
                swap(nums,i,nums[i]-1);
            }
            i++;
        }
        for(i=0; i<nums.length;i++){
            if(nums[i]-1 != i) return i+1;
        }
        return nums.length+1;
    }
    public void swap(int[]  nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}