class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        makeCombinations(candidates,0,target,0, new ArrayList<>(),arr);
        return arr;
    }
    public void makeCombinations(int[] arr, int start, int target,int sum,  List<Integer> curr, List<List<Integer>> list){
        if(start > arr.length)return;
        if(start==arr.length){
            if(sum == target){
                List li = new ArrayList(curr);
                list.add(li);
            }
            return;
        }
        if(sum > target)return;
        curr.add(arr[start]);
        makeCombinations(arr,start,target, sum+arr[start],curr,list);
        curr.remove(curr.size()-1);
        makeCombinations(arr,start+1,target,sum,curr,list);
    }
}