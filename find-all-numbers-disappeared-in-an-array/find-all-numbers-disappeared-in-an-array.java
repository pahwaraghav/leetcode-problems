class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hset = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            hset.add(nums[i]);
        }
        List<Integer> arr = new ArrayList<Integer>();
        for(int i=1; i<=nums.length;i++){
            if(!hset.contains(i)){
                arr.add(i);
            }
        }
        return arr;
    }
}