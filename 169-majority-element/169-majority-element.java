class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count =0;
        for(int i=0; i<nums.length;i++){
            if(count == 0){
                res= i;
                count++;
            }
            else if(nums[res] == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return nums[res];
    }
}