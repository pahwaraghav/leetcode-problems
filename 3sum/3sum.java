class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<2){
            List<List<Integer>> temp =  new ArrayList<List<Integer>>();
            return temp;
        }
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length -1;
            int currentSum = 0;
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])){          
                while(left<right){
                    currentSum = nums[i] + nums[left] + nums[right];

                    if(currentSum == 0){
                        List<Integer> tempList = new ArrayList<Integer>();
                        tempList.add(nums[i]);
                        tempList.add(nums[left]);
                        tempList.add(nums[right]);
                        res.add(tempList);
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        right--;
                        left++;
                    }
                    else if(currentSum > 0){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
}