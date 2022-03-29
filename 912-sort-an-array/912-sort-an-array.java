class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }
    public void sort(int[] nums, int l, int r){
        if(l<r){
            int mid = (l + r) /2;
            sort(nums,l,mid);
            sort(nums,mid+1,r);
            merge(nums,l,mid,r);
        }
    }
    public void merge(int[] nums, int l, int m, int r){
        if(l>=r){
           return;
        }
        int i1=l;
        int i2 = m+1;
        int[] arr = new int[r-l+1];
        int j=0;
        while(i1<=m || i2<=r){
            int num  = 0;
            if(i1<= m && i2<=r){
                if(nums[i1] <= nums[i2]){
                    num = nums[i1];
                    i1++;
                }
                else{
                    num = nums[i2];
                    i2++;
                }
            }
            else if(i1 <= m){
                num = nums[i1];
                i1++;
            }
            else{
                num = nums[i2];
                i2++;
            }
            arr[j] = num;
            j++;
        }
        j= 0;
        for(int i=l; i<=r;i++){
            nums[i] = arr[j++];
        }
    }
}