class Solution {
    public int fib(int n) {
        int a = 0;
        int b = 1;
        if(n < 2){
            return n;
        }
        for(int i=0; i<n-1; i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}