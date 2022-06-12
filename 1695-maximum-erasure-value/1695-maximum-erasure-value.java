class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int[] preSums = new int[nums.length];
        for(int i=0; i<nums.length;i++){
            if(i==0){
                preSums[i] = nums[i];
            }
            else{
                preSums[i] = nums[i] + preSums[i-1];
            }
        }
        int res = 0;
        int currSum = 0;
        int i = 0;
        for(int j=0; j<nums.length;j++){
            if(hmap.containsKey(nums[j]) && hmap.get(nums[j]) >=i){
                currSum = preSums[j-1] - preSums[hmap.get(nums[j])];
                currSum += nums[j];
                i = hmap.get(nums[j]) + 1;
            }
            else{
                currSum += nums[j];
            }
            // System.out.println(i + " " + j + " " + currSum);
            res = Math.max(res,currSum);
            hmap.put(nums[j],j);
        }
        return res;
    }
}