class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        makeSubsets(nums,curr, 0, arr);
        return arr;
    }
    
    public void makeSubsets(int[] nums, List<Integer> curr, int start, List<List<Integer>> arr){
        if(start >= nums.length){
             List<Integer> newCurr = new ArrayList<Integer>(curr);
            arr.add(newCurr);
            return;
        }
        curr.add(nums[start]);
        makeSubsets(nums, curr , start+1, arr);
        curr.remove(curr.size()-1);
        makeSubsets(nums, curr , start+1, arr);
    }
}