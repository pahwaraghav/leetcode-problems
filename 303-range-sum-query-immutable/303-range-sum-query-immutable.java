class NumArray {
    int[] preSums;
    public NumArray(int[] nums) {
        preSums = new int[nums.length];
        for(int i=0; i<nums.length;i++){
            if(i==0) preSums[i] = nums[i];
            else preSums[i] = preSums[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return preSums[right] - (left == 0 ? 0 : preSums[left-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */