class Solution {
    public int fib(int n) {
        int[] arr = new int[2];
        arr[0] = 0;
        arr[1] = 1;
        if(n<2) return arr[n];
        while(n>=2){
            int temp = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] = temp;
            n--;
        }
        return arr[1];
    }
}