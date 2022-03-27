class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Pair[] arr = new Pair[mat.length];
        for(int i=0; i<mat.length;i++){
            int num = lowerBoundOf0(mat[i]);
            Pair p = new Pair(i,num);
            arr[i] = p;
        }
        Arrays.sort(arr,(a,b) -> Integer.compare(a.num2,b.num2));
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = arr[i].num1;
        }
        return res;
    }
    
    public int lowerBoundOf0(int[] arr){
        int start = 0;
        int end = arr.length -1;
        
        int ele = 0;
        while(start <= end){
            int mid = (start + end) /2;
            if(ele < arr[mid]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        if(start < arr.length && arr[start] < ele){
            start++;
        }
        
        return start;
    }
}

class Pair{
    int num1;
    int num2;
    Pair(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
}