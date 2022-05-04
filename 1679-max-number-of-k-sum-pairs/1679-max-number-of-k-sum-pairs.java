class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int res = 0;
        for(int num: nums){
            if(hmap.getOrDefault(k - num,0) != 0){
                res++;
                hmap.put(k-num,hmap.get(k-num)-1);
            }
            else{
                hmap.put(num,hmap.getOrDefault(num,0)+1);
            }
        }
        return res;
    }
}