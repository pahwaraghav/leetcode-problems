class Solution {
    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);
        if(n<=2) return 0;
        arr[0] = arr[1] = false;
        int count = 1;
        for(int i=3; i<n; i+=2){
            if(arr[i] == false) continue;
            count++;
            int j = 2;
            while(i*j<n){
                arr[i*j] = false;
                j++;
            }
        }
        return count;
    }
}