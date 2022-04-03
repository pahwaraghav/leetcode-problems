class Solution {
    public double myPow(double x, int n) {
        long num = n > 0 ? n : -n;
        double res = helper(x,num);
        if(n<0){
            res = 1/res;
        }
        return res;
    }
    public double helper(double x, long n){
        if(n==0) return 1;
        if(n % 2 == 0){
            return helper(x*x,n/2);
        }
        return x * helper(x*x,n/2);
    }
}