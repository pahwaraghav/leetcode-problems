class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int maxEndSoFar = Integer.MIN_VALUE;
        int ans = 0;
        for(int[] interval:  intervals) {
            if(interval[0] >= maxEndSoFar) {
                maxEndSoFar = interval[1];
            }
            else {
                ans++;
            }
        }
        return ans;
    }
}