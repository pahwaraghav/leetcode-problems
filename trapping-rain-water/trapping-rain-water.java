class Solution {
    public int trap(int[] height) {
        int[] rh = new int[height.length];
        rh[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--) {
            rh[i] = Math.max(rh[i+1], height[i]);
        };
        int lh = height[0];
        int ans = 0;
        for(int i=1; i<height.length; i++){
            int currHeight = Math.min(lh, rh[i]) - height[i];
            if(currHeight < 0) currHeight = 0;
            ans += currHeight;
            lh = Math.max(lh, height[i]);
        }
        return ans;
    }
}