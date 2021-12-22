class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIdx = Integer.MIN_VALUE;
        int numIdx = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroIdx = i;
                break;
            }
        }
        if(zeroIdx<0) return;
        for(int i=zeroIdx; i<nums.length;i++){
            if(nums[i]!=0){
                numIdx = i;
                break;
            }
        }
        if(numIdx<0){
            return;
        }
        while(zeroIdx < nums.length && numIdx <nums.length){
            swap(nums,zeroIdx,numIdx);
            zeroIdx++;
            numIdx++;
            
            while(zeroIdx<nums.length && nums[zeroIdx]!=0){
                zeroIdx++;
            }
            while(numIdx<nums.length && nums[numIdx]==0){
                numIdx++;
            }
        }
    }
    public void swap (int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}