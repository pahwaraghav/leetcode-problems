class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(true){
            while(left <= right){
                if(nums[left] %2 != 0){
                    break;
                }
                left++;
            }
            while(right >= left){
                if(nums[right] %2 == 0){
                    break;
                }
                right--;
            }
            if(left >= right) break;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}