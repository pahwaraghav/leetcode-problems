class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i=0; i<arr.length;i++){
            if(arr[i] == 0){
                shiftRight(arr,i+1);
                if(i+1<arr.length) arr[i+1] = 0;
                i++;
            }
        }
    }
    public void shiftRight(int[] arr, int start){
        for(int i=arr.length-1;i>start;i--){
            arr[i] = arr[i-1];
        }
    }
}