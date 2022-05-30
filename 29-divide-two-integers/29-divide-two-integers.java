class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 1 << 31 && divisor == -1) return (1 << 31) -1;
        int num1 = Math.abs(dividend);
        int num2 = Math.abs(divisor);
        int res = 0;
        for(int x=31; x>=0; x--){
            if((num1 >>> x) - num2 >= 0){
                res +=1 << x;
                num1 -= num2 << x;
            }
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
}