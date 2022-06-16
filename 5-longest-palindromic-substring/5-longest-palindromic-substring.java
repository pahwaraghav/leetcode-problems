class Solution {
    public String longestPalindrome(String s) {
        int[] ans = new int[]{0,1};
        for(int i=1; i<s.length();i++){
            int[] left = getLongestPalindrome(s,i-1,i+1);
            int[] right = getLongestPalindrome(s,i-1,i);
            int[] greater = left[1] > right[1] ? left : right;
            if(ans[1] - ans[0] < greater[1] - greater[0]) ans = greater;
        }
        return s.substring(ans[0],ans[1]);
    }
    public int[] getLongestPalindrome(String s, int left,int right){
        while(left >=0 && right <s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right ++;
            }
            else{
                break;
            }
        }
        return new int[]{left+1,right};
    }
}