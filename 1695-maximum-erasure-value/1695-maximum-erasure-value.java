class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        int currSum = 0;
        int res = 0;
        int i=0;
        int j=0;
        while(i<nums.length && j<nums.length){
            if(!hset.contains(nums[j])){
                currSum += nums[j];
                res = Math.max(res,currSum);
                hset.add(nums[j]);
                j++;
            }
            else {
                currSum -= nums[i];
                hset.remove(nums[i]);
                i++;
            }
        }
        return res;
    }
}