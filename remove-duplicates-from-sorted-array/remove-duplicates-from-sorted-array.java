class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 1;
        while(i<len){
            if(nums[i] == nums[i-1]){
                for(int j =i; j<len-1;j++){
                    nums[j] = nums[j+1];
                }
                len--;
            }
            else{
                i++;
            }
        }
        return len;
    }
}