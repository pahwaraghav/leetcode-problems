class Solution {
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> hset = new HashSet<Integer>();
        Arrays.sort(nums);
   
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(hset.contains(nums[i] + k) || hset.contains(nums[i]-k)){
                count++;
               
                while(i+1<nums.length && nums[i+1] == nums[i]) i++;
            }
            
            hset.add(nums[i]);
        }
        return count;
    }
}