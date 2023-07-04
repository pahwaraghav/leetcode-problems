class Solution {
    public int distMoney(int money, int children) {
        if(money < children) return -1;
        if(money < 8) return 0;
        int count = 0;
        int num = 0;
        while(count<children && money - (num+8) >= (children - count-1)) {
            count++;
            num += 8;
        }
        if(count == children - 1 && (money - 8 * count == 4)) {
            return count-1;
        }
        if(count == children) {
            return count * 8 == money ? count : count -1;
        }
        return count;
    }
}