class Solution {
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price: prices){
            minVal = Math.min(minVal, price);
            maxProfit = Math.max(maxProfit, price - minVal);
        }
        return maxProfit;
    }
}