class Solution {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length-1];
        int prev = arr[arr.length-1];
        for(int i=arr.length-1; i>=0; i--){
            prev = arr[i];
            if(i == arr.length-1) arr[i] = -1;
            else arr[i] = max;
            max = Math.max(max,prev);
        }
        return arr;
    }
}