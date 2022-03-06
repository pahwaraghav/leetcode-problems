class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int res = 0;
        for(int i=0; i<nums.length;i++){
            if(hmap.containsKey(nums[i])){
                int val = hmap.get(nums[i]);
                res += val;
                hmap.put(nums[i], val+1);
            }
            else{
                hmap.put(nums[i],1);
            }
        }
        return res;
    }
}