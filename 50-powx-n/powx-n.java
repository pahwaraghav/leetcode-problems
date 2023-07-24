class Solution {
    public double myPow(double x, int n) {
        if(n>=0) return helper(x,n);
        return 1/helper(x,n);
    }
    public double helper(double x, int n) {
        if(n==0) return 1;
        double half = helper(x,n/2);
        if(n%2 == 0) return half * half;
        return half * half * x;
    }
}