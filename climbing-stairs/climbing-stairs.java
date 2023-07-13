class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] mem = new int[n+1];
        mem[1] = 1;
        mem[2] = 2;
        for(int i=3; i<=n; i++) {
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n];
    }
}