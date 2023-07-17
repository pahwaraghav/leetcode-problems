class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int count = 0;
        for(int i=piles.length-2; i>0; i-=2) {
            ans += piles[i];
            if(++count == piles.length/3) break;
        }
        return ans;
    }
}