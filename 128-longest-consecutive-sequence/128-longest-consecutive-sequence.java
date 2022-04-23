class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int num: nums){
            hset.add(num);
        }
        int ans = 0;
        Iterator<Integer> i=hset.iterator(); 
        while(i.hasNext()){
            int curr_ans = 0;
            int num = i.next();
            if(hset.contains(num-1)){
                continue;
            }
            curr_ans++;
            while(hset.contains(num+1)){
                curr_ans++;
                num++;
            }
            ans = Math.max(ans,curr_ans);
        }
        return ans;
    }
}