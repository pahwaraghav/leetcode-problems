class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int num: nums){
            if(getNumberOfDigits(num) %2 == 0) ans++;
        }
        return ans;
    }
    public int getNumberOfDigits(int num){
        int ans = 0;
        while(num !=0){
            num = num/10;
            ans++;
        }
        return ans;
    }
}