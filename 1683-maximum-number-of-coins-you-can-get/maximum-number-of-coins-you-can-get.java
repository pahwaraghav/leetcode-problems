class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int count = piles.length/3;
        for(int i=piles.length-2; i>0; i-=2) {
            ans += piles[i];
            if(--count == 0) break;
        }
        return ans;
    }
}