class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount+1];        
        for(int i=0; i<=amount;i++) res[i] = Integer.MAX_VALUE;
        res[0] = 0;
        for(int coin: coins){
            for(int i=coin; i<=amount;i++){
                if(res[i-coin] == Integer.MAX_VALUE) continue;
                res[i] = Math.min(res[i], res[i-coin]+1);
            }
        }
        int ans = res[amount];
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}