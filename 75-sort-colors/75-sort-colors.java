class Solution {
    public void sortColors(int[] nums) {
        int i1 = 0;
        int i2 = 0;
        int i3 = nums.length-1;
        while(i2<=i3 && i2<nums.length){
            if(nums[i2] == 0){
                swap(nums,i1,i2);
                i1++;
                i2++;
            }
            else if(nums[i2] == 1){
                i2++;
            }
            else{
                swap(nums,i2,i3);
                i3--;
            }
        }
    }
    public void swap(int[] nums,int i1, int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}