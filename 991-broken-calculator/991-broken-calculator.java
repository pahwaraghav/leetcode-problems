class Solution {
    public int brokenCalc(int startValue, int target) {
        int res = 0;
        while(target > startValue){
            if(target %2 == 0){
                target = target /2;
            }
            else{
                target = target + 1;
            }
            res++;
        }
        int diff = startValue - target; // if target gets too small just increment it by 1 n times;
        
        return res + diff;
    }
}