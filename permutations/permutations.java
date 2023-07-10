class Solution {
    public List<List<Integer>> permute(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num: nums){
            hmap.put(num, hmap.getOrDefault(num,0)+1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, hmap, curr, ans);
        return ans;
    }
    public void helper(int[] nums, HashMap<Integer, Integer> hmap, List<Integer> curr, List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList(curr));
            return;
        }
        for(Map.Entry<Integer,Integer> e: hmap.entrySet()){
            if(e.getValue() == 0) continue;
            curr.add(e.getKey());
            hmap.put(e.getKey(), e.getValue()-1);
            helper(nums, hmap, curr, ans);
            curr.remove(curr.size()-1);
            hmap.put(e.getKey(), e.getValue()+1);
        }
    }
}

