class Solution {
    public int subarraySum(int[] nums, int k) {        
        int pSum = 0;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int count = 0;
        hmap.put(0,1);
        
        for(int i=0; i<nums.length; i++){
            pSum += nums[i];
            if(hmap.containsKey(pSum - k)){
                int val = hmap.get(pSum - k);
                count += val;
            }
            if(hmap.containsKey(pSum)){
                int val = hmap.get(pSum);
                hmap.put(pSum, val+1);
            }
            else{
                hmap.put(pSum, 1);
            }
        }
        return count;
    }
}