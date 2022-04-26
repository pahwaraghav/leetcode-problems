class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int i=1;
        while(true){
            if(i >= arr.length) return false;
            if(arr[i] > arr[i-1]) i++;
            else break;
        }
        if(i<=1) return false;
        while(true){
            if(i >= arr.length) return true;
            if(arr[i-1] > arr[i]) i++;
            else return false;
        }
    }
}