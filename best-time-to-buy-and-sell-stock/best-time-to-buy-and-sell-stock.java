class Solution {
    public int maxProfit(int[] prices) {
        int smallestSoFar = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - smallestSoFar);
            smallestSoFar = Math.min(smallestSoFar, prices[i]);
        }
        return maxProfit;
    }
}