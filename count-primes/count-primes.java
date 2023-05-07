class Solution {
    public int countPrimes(int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        if(n<2) return 0;
        arr[0] = arr[1] = 0;
        int count = 0;
        for(int i=2; i<n; i++){
            if(arr[i] == 0) continue;
            count++;
            int j = 2;
            while(i*j<n){
                arr[i*j] = 0;
                j++;
            }
        }
        return count;
    }
}