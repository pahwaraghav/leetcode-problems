class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int j=m+n-1;
        while(j>=0){
            int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE;
            if(p1>=0) num1 = nums1[p1];
            if(p2>=0) num2 = nums2[p2];
            if(num1 > num2){
                nums1[j] = num1;
                p1--;
            }
            else{
                nums1[j] = num2;
                p2--;
            }
            j--;
        }
    }
}