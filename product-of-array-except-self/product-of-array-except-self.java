class Solution {
    public int[] productExceptSelf(int[] nums) {    
        int[] arr = new int[nums.length];
        arr[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            arr[i] = nums[i] * arr[i+1];
        }
        int product = nums[0];
        arr[0] = arr[1];
        for(int i=1; i<nums.length-1; i++){
            arr[i] = product * arr[i+1];
            product *= nums[i];
        }
        arr[arr.length-1] = product;
        return arr;
    }
}