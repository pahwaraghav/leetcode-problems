class Solution {
    public int heightChecker(int[] heights) {
        int[] heightsCopy = heights.clone();
        Arrays.sort(heightsCopy);
        int res = 0;
        for(int i=0; i<heights.length;i++){
            if(heights[i] != heightsCopy[i]) res++;
        }
        return res;
    }
}