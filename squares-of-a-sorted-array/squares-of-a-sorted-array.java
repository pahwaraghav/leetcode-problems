class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int smallest = 0;
        int largest = nums.length -1;
        int i=nums.length -1;
        while(i>=0){
            if(Math.abs(nums[smallest])>Math.abs(nums[largest])){
                arr[i] = nums[smallest] * nums[smallest];
                smallest++;
            }
            else{
                arr[i] = nums[largest] * nums[largest];
                largest--;
            }
            i--;
        }
        return arr;
    }
}