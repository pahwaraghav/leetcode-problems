class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];;
        int carry = 0;
        for(int i=digits.length-1;i>=0; i--){
            int sum = digits[i] + carry;
            if(i==digits.length-1) sum++;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
            }
            else{
                carry = 0;
            }
            res[i] = sum;
        }
        if(carry > 0){
            int[] temp = new int[digits.length+1];
            temp[0] = 1;
            for(int i=0; i<res.length;i++){
                temp[i+1] = res[i];
            }
            res = temp;
        }
        return res;
    }
}