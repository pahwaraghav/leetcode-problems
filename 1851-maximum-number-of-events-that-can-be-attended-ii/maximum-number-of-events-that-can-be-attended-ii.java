class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a,b) -> a[0]-b[0]);
        int[][] dp = new int[k+1][events.length];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return helper(events, k, 0, dp);
    }
    public int helper(int[][] events, int count, int i, int[][] dp) {
        if(count == 0 || i>=events.length || i<0) {
            return 0;
        }
        if(dp[count][i] != -1) {
            return dp[count][i];
        }
        int notTake = helper(events,count, i+1, dp);
        int take = events[i][2] + helper(events, count-1, right(events, events[i][1], i), dp);
        return dp[count][i] = Math.max(notTake, take);
    }
    public int right(int[][] events, int num, int start) {
        int left = start+1;
        int right = events.length -1;
        int ans = -1;
        while(left<= right) {
            int mid = left + (right - left) / 2;
            if(events[mid][0] > num) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }
}