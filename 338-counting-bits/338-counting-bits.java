class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i=0; i<=n;i++){
            arr[i] = count(i);
        }
        return arr;
    }
    public int count(int n){
        int res = 0;
        while(n!=0){
            int bit = n & 1;
            if(bit == 1)res++;
            n = n>>1;
        }
        return res;
    }
}