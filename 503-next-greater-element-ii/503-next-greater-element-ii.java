class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n*2; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                res[st.pop()] = nums[i%n];
            }
            st.push(i%n);
        }
        return res;
    }
}