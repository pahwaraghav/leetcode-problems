class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] arr = new List[nums.length+1];
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int num: nums){
            hmap.put(num,hmap.getOrDefault(num,0) + 1);
        }
        for(int key: hmap.keySet()){
            int freq = hmap.get(key);
            if(arr[freq] == null){
                arr[freq] = new ArrayList<>();
            }
            arr[freq].add(key);
        }
        int[] ans = new int[k];
        int j = 0;
        for(int i= arr.length-1;i >=0 && j<k; i--){
            if(arr[i] != null){
                for(int val : arr[i]){
                    ans[j++] = val;
                }
            }
        }
        return ans;
    }
}