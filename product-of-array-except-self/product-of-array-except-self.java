class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] post = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            if(i==nums.length-1) post[i] = nums[i];
            else post[i] = nums[i] * post[i+1];
        }
        int pre = 1;
        for(int i=0; i<nums.length; i++){
            int temp = pre * nums[i];
            if(i==0) nums[i] = post[i+1];
            if(i==nums.length-1) nums[i] = pre;
            else nums[i] = pre * post[i+1];
            pre = temp;
        }
        return nums;
    }
}