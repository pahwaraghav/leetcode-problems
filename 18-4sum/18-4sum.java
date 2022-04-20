class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length;i++){
            for(int j=i+1; j<nums.length;j++){
                int left = j+1;
                int right = nums.length-1;
                int sum = nums[i] + nums[j];
                int target_sum = target - sum;
                while(left < right){
                    int two_sum = nums[left] + nums[right];
                    if(two_sum < target_sum) left++;
                    else if(two_sum > target_sum) right--;
                    else{
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        res.add(ans);
                        while(left < right && nums[left] == ans.get(2)) left++;
                        while(left < right && nums[right] == ans.get(3)) right--;
                    }
                }
                while(j+1 < nums.length && nums[j+1] == nums[j]) j++;
            }
            while(i+1 < nums.length && nums[i+1] == nums[i]) i++;
        }
        return res;
    }
}