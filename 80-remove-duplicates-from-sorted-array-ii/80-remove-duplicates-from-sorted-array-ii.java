class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = 0;
        int j=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                if(prev==0){
                    nums[j] = nums[i];
                    j++;prev++;
                }
            }
            else{
                nums[j] = nums[i];
                j++;
                prev=0;
            }
        }
        return j;
    }
}