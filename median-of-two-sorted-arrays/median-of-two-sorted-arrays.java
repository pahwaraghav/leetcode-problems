class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int target = (nums1.length + nums2.length + 1) /2;
        System.out.println(target);
        int low = 0;
        int high = nums1.length;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int numsA = mid;
            int numsB = target - mid;
            int num1 = numsA != 0 ? nums1[mid-1] : min;
            int num2 = numsA != nums1.length ? nums1[mid] : max;
            int num3 = numsB != 0 && mid < target ? nums2[numsB-1] : min;
            int num4 = numsB != nums2.length ? nums2[numsB] : max;

            if(num1 <= num4 && num3 <= num2) {
                if((nums1.length + nums2.length) % 2== 0) {
                    return (Math.max(num1,num3) + Math.min(num2,num4))/2.0;
                }
                return Math.max(num1,num3);
            }
            if(num1 > num4) {
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}