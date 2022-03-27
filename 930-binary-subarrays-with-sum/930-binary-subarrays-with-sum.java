class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        hmap.put(0,1);
        int res = 0;
        int sum = 0;
        for(int i=0; i<nums.length;i++){
            sum += nums[i];
            int num = hmap.getOrDefault(sum - goal,0);
            res += num;
            hmap.put(sum,hmap.getOrDefault(sum,0)+1);
        }
        return res;
    }
}