class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<nums.length;i++){
            if(!hset.contains(nums[i])){
                pq.offer(nums[i]);
            }
            hset.add(nums[i]);
        }
        if(hset.size() < 3){
            return pq.poll();
        }
        else{
            pq.poll();
            pq.poll();
            return pq.poll();
        }
    }
}