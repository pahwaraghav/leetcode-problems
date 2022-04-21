class Solution {
    public int[] replaceElements(int[] arr) {
        int[] maxEle = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            if(i == arr.length-1) maxEle[i] = arr[i];
            else maxEle[i] = Math.max(maxEle[i+1],arr[i]);
        }
        for(int i=0; i<arr.length;i++){
            if(i==arr.length-1) arr[i] = -1;
            else arr[i] = maxEle[i+1];
        }
        return arr;
    }
}