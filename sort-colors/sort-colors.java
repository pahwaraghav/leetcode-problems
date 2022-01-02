class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int temp = 0;
        int right = nums.length - 1;
        while(mid <= right && mid <nums.length){
            if(nums[mid] == 0){
                temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                temp = nums[right];
                nums[right] = nums[mid];
                nums[mid] = temp;
                right--;
            }
        }
    }
}