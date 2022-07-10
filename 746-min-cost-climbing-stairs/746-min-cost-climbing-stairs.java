class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0;
        int b = cost[cost.length-1];
        for(int i=cost.length-2; i>=0; i--){
            int c = cost[i] + Math.min(a,b);
            a = b;
            b = c;
        }
        return Math.min(a,b);
    }
}