class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int num: nums){
            hset.add(num);
        }
        int ans = 0;
        for(int i=0; i<nums.length;i++){
            int curr_ans = 0;
            if(hset.contains(nums[i]-1)){
                continue;
            }
            curr_ans++;
            int num = nums[i];
            while(hset.contains(num+1)){
                curr_ans++;
                num++;
            }
            ans = Math.max(ans,curr_ans);
        }
        return ans;
    }
}