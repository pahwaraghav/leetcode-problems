class Solution {
    public int change(int amount, int[] coins) {
        int[] res = new int[amount+1];
        res[0] = 1;
        for(int coin: coins){
            for(int i=1; i<res.length;i++){
                if(coin<=i){
                    res[i] += res[i-coin];
                }
            }
        }
        return res[res.length-1];
    }
}