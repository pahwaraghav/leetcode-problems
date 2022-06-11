class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum == x) return nums.length;
        int reqSum = sum -x;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,-1);
        sum = 0;
        int res = Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++){
            sum += nums[i];
            if(hmap.containsKey(sum - reqSum)){
                res = Math.max(res, i - hmap.get(sum-reqSum));
            }
            hmap.put(sum,i);
        }
        if(res == Integer.MIN_VALUE) return -1;
        return nums.length - res;
    }
}