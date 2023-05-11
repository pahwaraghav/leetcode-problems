class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] prev = new int[nums2.length+1];
        for(int i=0; i<nums1.length; i++){
            int[] curr = new int[nums2.length+1];
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    curr[j+1] = 1 + prev[j];
                }
                else{
                    curr[j+1] = Math.max(curr[j], prev[j+1]);
                }
            }
            prev = curr;
        }
        return prev[nums2.length];
    }
}