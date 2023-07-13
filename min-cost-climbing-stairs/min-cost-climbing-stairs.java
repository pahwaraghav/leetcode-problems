class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] mem = new int[cost.length];
        Arrays.fill(mem,-1);
        return Math.min(helper(cost, cost.length-1, mem), helper(cost, cost.length-2, mem));
    }
    public int helper(int[] cost, int i, int[] arr) {
        if(i<0) return 0;
        if(arr[i] != -1) return arr[i];
        int one = helper(cost, i-1, arr);
        int two = helper(cost, i-2, arr);
        return arr[i] =  cost[i] + Math.min(one,two);
    }
}