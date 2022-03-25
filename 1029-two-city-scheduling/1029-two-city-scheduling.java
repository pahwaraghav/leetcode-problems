class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        int[] refund = new int[costs.length];
        
        for(int i=0;i<costs.length;i++){
            refund[i] = costs[i][1] - costs[i][0];
            sum += costs[i][0];
        }
        
        Arrays.sort(refund);
        for(int i=0; i<refund.length/2;i++){
            sum += refund[i];
        }
        return sum;
    }
}