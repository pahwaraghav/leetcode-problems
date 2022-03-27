class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        hmap.put(0,1);
        int res = 0;
        for(int i=0; i<nums.length;i++){
            if(i != 0){
                nums[i] += nums[i-1];
            }
            int num = hmap.getOrDefault(nums[i] - goal,0);
            res += num;
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0)+1);
        }
        return res;
    }
}