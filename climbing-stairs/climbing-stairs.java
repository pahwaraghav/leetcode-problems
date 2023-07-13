class Solution {
    public int climbStairs(int n) {
        int[] mem = new int[n+1];
        return helper(mem, n);
    }
    public int helper(int[] arr, int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(arr[n] != 0) return arr[n];
        return arr[n] = helper(arr, n-1) + helper(arr, n-2);
    }
}