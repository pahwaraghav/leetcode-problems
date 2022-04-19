class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int l1 = getMaxAmount(nums,0,nums.length-2);
        int l2 = getMaxAmount(nums,1,nums.length-1);
        return Math.max(l1,l2);
    }
    public static int getMaxAmount(int[] nums,int start, int end){
        int[] arr = new int[end-start+1];
        for(int i=start; i<=end;i++){
            if(i==start){
                arr[i-start] = nums[i];
            }
            else if(i==start+1){
                arr[i-start] = Math.max(nums[i-1],nums[i]);
            }
            else{
                arr[i-start] = Math.max(arr[i-start-2] + nums[i], arr[i-start-1]);
            }
        }
        return arr[arr.length-1];
    }
}