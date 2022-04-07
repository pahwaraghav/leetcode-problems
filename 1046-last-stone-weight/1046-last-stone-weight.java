class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(stones.length,(a,b)->Integer.compare(b,a));
        for(int i=0; i<stones.length;i++){
            q.add(stones[i]);
        }
        while(q.size()>1){
            int num1 = q.remove();
            int num2 = q.remove();
            if(num1 != num2){
                q.add(num1-num2);
            }
        }
        if(q.size() == 0){
            return 0;
        }
        return q.remove();
    }
}