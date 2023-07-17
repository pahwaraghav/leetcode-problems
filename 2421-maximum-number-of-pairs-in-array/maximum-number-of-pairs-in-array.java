class Solution {
    public int[] numberOfPairs(int[] nums) {
        int pairs = 0;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int val: nums) {
            if(hmap.containsKey(val) && hmap.get(val) != 0) {
                hmap.put(val, hmap.get(val)-1);
                pairs++;
            }
            else {
                hmap.put(val, hmap.getOrDefault(val,0)+1);
            }
        }
        return new int[]{pairs, nums.length - (2*pairs)};
    }
}