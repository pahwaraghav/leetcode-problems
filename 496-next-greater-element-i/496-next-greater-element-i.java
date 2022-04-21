class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer,Integer> hmap = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums2.length;i++){
            while(!st.isEmpty() && nums2[st.peek()] < nums2[i]){
                hmap.put(nums2[st.pop()],nums2[i]);
            }
            st.push(i);
        }
        for(int i=0; i<nums1.length;i++){
            if(hmap.containsKey(nums1[i])){
                res[i] = hmap.get(nums1[i]);
            }
            else{
                res[i] = -1;
            }
        }
        return res;
    }
}