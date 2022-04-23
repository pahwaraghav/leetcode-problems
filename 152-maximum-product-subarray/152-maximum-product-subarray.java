class Pair{
    int min;
    int max;
    Pair(){}
    Pair(int min, int max){
        this.min = min;
        this.max = max;
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        Pair[] arr = new Pair[nums.length];
        for(int i=0; i<nums.length;i++){
            if(i==0){
                arr[i] = new Pair(nums[i],nums[i]);
            }
            else{
                Pair p = new Pair();
                p.min = Math.min(nums[i], Math.min(arr[i-1].min*nums[i],arr[i-1].max*nums[i]));
                p.max = Math.max(nums[i], Math.max(arr[i-1].min*nums[i],arr[i-1].max*nums[i]));
                arr[i] = p;
            }
            res = Math.max(res,Math.max(arr[i].min,arr[i].max));
        }
        return res;
    }
}