class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] leftSmallest = new int[heights.length];
        int[] rightSmallest = new int[heights.length];

        Arrays.fill(leftSmallest,-1);
        Arrays.fill(rightSmallest,-1);

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<heights.length; i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int idx = st.pop();
                rightSmallest[idx] = i;
            }
            st.push(i);
        }
        st.empty();
        for(int i=heights.length-1; i>=0; i--) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int idx = st.pop();
                leftSmallest[idx] = i;
            }
            st.push(i);
        }
        int ans = 0;
        for(int i=0; i<heights.length; i++) {
            int left = leftSmallest[i];
            int right = rightSmallest[i] == -1 ? heights.length : rightSmallest[i];
            int area = (right - left - 1) * heights[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }
}