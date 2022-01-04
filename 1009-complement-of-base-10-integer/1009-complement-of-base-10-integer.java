class Solution {
    public int bitwiseComplement(int n) {
        int ones = 1;
        while(ones < n){
            ones = ones * 2 + 1;
        }
        return ones - n;
    }
}