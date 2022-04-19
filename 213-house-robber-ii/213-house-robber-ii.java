class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int l1 = getMaxAmount(nums,0,nums.length-2);
        int l2 = getMaxAmount(nums,1,nums.length-1);
        return Math.max(l1,l2);
    }
    public static int getMaxAmount(int[] nums,int start, int end){
        if(end-start == 0){
            return nums[start];
        }
        if(end-start == 1){
            return Math.max(nums[start],nums[end]);
        }
        int a = nums[start];
        int b = Math.max(nums[start],nums[start+1]);
        int c = 0;
        int res = b;
        for(int i=start+2; i<=end;i++){
            c = Math.max(a+nums[i],b);
            a = b;
            b = c;
            res = Math.max(res,c);
        }
        return res;
    }
}