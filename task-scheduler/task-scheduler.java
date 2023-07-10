class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        int[] freq = new int[26];
        for(char ch: tasks) {
            freq[ch-'A']++;
        }
        for(int num: freq) {
            if(num != 0) pq.offer(num);
        }
        int time = 0;
        while(!pq.isEmpty()) {
            ArrayList<Integer> nums = new ArrayList<>();
            int i=0;
            for(;!pq.isEmpty() && i<=n; i++) {
                int val = pq.poll();
                time++;
                if(val > 1) {
                    nums.add(val-1);
                }
            }
            if(i<=n && !nums.isEmpty()) time += n - i +1;
            for(int num: nums) pq.offer(num);
        }
        return time;

    }
}
