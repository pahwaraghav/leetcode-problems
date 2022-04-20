class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int p = 0;
        while(p<nums.length){
            if(nums[p] >= 0) break;
            p++;
        }
        int l = p-1;
        int r = p;
        
        int j = 0;
        while(l>=0 || r<nums.length){
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            if(l>= 0) left = Math.abs(nums[l]);
            if(r<nums.length) right = nums[r];
            
            if(left < right){
                res[j] = left*left;
                l--;
            }
            else{
                res[j] = right*right;
                r++;
            }
            j++;
        }
        return res;
    }
}