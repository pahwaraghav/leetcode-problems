class Solution {
    int[] ans;
    public List<Integer> countSmaller(int[] nums) {
        ans = new int[nums.length];
        int[][] temp = new int[nums.length][2];
        for(int i =0; i < nums.length; i++) {
            temp[i] = new int[]{nums[i], i};
        }
        
        temp = mergeSort(temp);
        List<Integer> Fans = new ArrayList<>();
        for(int i: ans) {
            Fans.add(i);
        }
        
        return Fans;
    }
    
    public int[][] mergeSort(int[][] arr) {
        if(arr.length == 1) {
            return arr;
        }
        
        int[][] left = mergeSort(Arrays.copyOfRange(arr,0,arr.length/2));
        int[][] right = mergeSort(Arrays.copyOfRange(arr,arr.length/2, arr.length));
        
        return merge(left,right);
    }
    
    public int[][] merge(int[][] left, int[][] right) {
        int i =0;
        int j = 0;
        int idx = 0;
        int[][] mergeArr = new int[left.length + right.length][2];
        
        while(i < left.length && j < right.length) {
            if(right[j][0] < left[i][0]) {
                ans[left[i][1]] += right.length - j;
                mergeArr[idx] = left[i];
                i++;
            } else {
                mergeArr[idx] = right[j];
                j++;
            }
            idx++;
        }
        
        while(i < left.length) {
            mergeArr[idx] = left[i];
            i++;
            idx++;
        }
        
        while(j < right.length) {
            mergeArr[idx] = right[j];
            j++;
            idx++;
        }
        
        return mergeArr;
    }
}