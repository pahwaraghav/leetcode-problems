class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] preSum = new int[nums.length];
        int[] postSum = new int[nums.length];
        for(int i=0; i<nums.length;i++){
            if(i==0){
                preSum[i] = nums[i];
            }
            else{
                preSum[i] = nums[i] + preSum[i-1];
            }
        }
        for(int i=nums.length-1; i>=0;i--){
            if(i == nums.length-1){
                postSum[i] = nums[i];
            }
            else{
                postSum[i] = postSum[i+1] + nums[i];
            }
        }
        int[] res = new int[nums.length];
        for(int i=0; i<res.length;i++){
            int lNum = 0, rNum = 0;
            if(i!=0){
                lNum = i * nums[i] - preSum[i-1];
            }
            if(i != res.length -1){
                rNum = postSum[i+1] - (res.length-1-i) * nums[i];
            }
            res[i] = lNum + rNum;
        }
        return res;
    }
}