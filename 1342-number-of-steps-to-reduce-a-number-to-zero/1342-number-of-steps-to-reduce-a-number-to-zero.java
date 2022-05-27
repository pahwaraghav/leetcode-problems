class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        if(num == 0) return 0;
        while(num != 0){
            int bit = num & 1;
            if(bit == 1) steps+=2;
            else steps++;
            num = num >> 1;
        }
        return steps-1;
    }
}