class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int left = 2;
        int right = piles.length-1;
        //System.out.println(Arrays.toString(piles));
        int count = 0;
        for(int i=piles.length-2; i>0; i-=2) {
            count++;
            ans += piles[i];
            if(count == piles.length/3) break;
        }
        return ans;
    }
}