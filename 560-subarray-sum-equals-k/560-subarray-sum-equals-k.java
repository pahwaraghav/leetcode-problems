class Solution {
    public int subarraySum(int[] nums, int k) {        
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for(int i=1; i<=nums.length; i++){
            preSum[i] = nums[i-1] + preSum[i-1];
        }
        
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int count = 0;
        
        for(int i=0; i<preSum.length; i++){
            if(hmap.containsKey(preSum[i] - k)){
                int val = hmap.get(preSum[i] - k);
                count += val;
            }
            if(hmap.containsKey(preSum[i])){
                int val = hmap.get(preSum[i]);
                hmap.put(preSum[i], val+1);
            }
            else{
                hmap.put(preSum[i], 1);
            }
        }
        return count;
    }
}