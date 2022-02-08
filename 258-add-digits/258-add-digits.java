class Solution {
    public int addDigits(int num) {
        while(num >9){
            num = digitsSum(num);
        }
        return num;
    }
    public int digitsSum(int num){
        int sum = 0;
        while(num != 0){
            int rem = num %10;
            num = num /10;
            sum += rem;
        }
        return sum;
    }
}