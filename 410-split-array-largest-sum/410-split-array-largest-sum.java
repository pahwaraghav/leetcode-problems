class Solution {
    public int splitArray(int[] nums, int m) {
        long maxVal = 0;
        long sum = 0;
        for(int num : nums){
            maxVal = Math.max(maxVal,num);
            sum += num;
        }
        if(m==1) return (int)sum;
        long l=maxVal, r=sum;
        while(l<=r){
            long mid = (l + r) /2;
            if(isValid(mid,nums,m)){
                r = mid -1;
            }
            else{
                l = mid+1;
            }
        }
        return (int) l;
    }
    public boolean isValid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}