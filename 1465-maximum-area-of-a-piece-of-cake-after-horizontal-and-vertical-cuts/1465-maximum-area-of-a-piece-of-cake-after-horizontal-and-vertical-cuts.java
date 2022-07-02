class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int horizontalDistance= Math.max(horizontalCuts[0], h-horizontalCuts[horizontalCuts.length-1]);
        for(int i=0; i<horizontalCuts.length-1; i++){
            horizontalDistance = Math.max(horizontalDistance, horizontalCuts[i+1]-horizontalCuts[i]);
        }
        
        
        int verticalDistance= Math.max(verticalCuts[0], w -verticalCuts[verticalCuts.length-1]);
        for(int i=0; i<verticalCuts.length-1; i++){
            verticalDistance = Math.max(verticalDistance, verticalCuts[i+1]-verticalCuts[i]);
        }
        
        long ans = (long) horizontalDistance * verticalDistance % 1000000007;
        return (int) ans;
    }
}