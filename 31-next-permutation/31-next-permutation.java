class Solution {
    public void nextPermutation(int[] nums) {
        int first = 0, second = 0;
        int i = nums.length-2;
        while(i>=0){
            if(nums[i] < nums[i+1]){
                first = i;
                break;
            }
            i--;
        }
        if(i < 0){
            reverse(nums,0,nums.length-1);
            return;
        }
        i = nums.length-1;
        while(i>0){
            if(nums[i] > nums[first]){
                second = i;
                break;
            }
            i--;
        }
        swap(nums,first,second);
        reverse(nums,first+1,nums.length-1);
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void reverse(int[] arr, int i, int j){
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
}