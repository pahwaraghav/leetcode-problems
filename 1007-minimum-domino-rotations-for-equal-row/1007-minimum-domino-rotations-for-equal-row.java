class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int num1 = tops[0];
        int num2 = bottoms[0];
        
        int count1 = 0, count2=0, count3=0, count4=0;
        
        for(int i=0; i<tops.length;i++){
            if(tops[i] == num1){
            }
            else if(bottoms[i] == num1){
                if(count1 != Integer.MAX_VALUE) count1++;
            }
            else{
                count1 = Integer.MAX_VALUE;
            }
            
             if(bottoms[i] == num1){
                
            }
            else if(tops[i] == num1){
                if(count2 != Integer.MAX_VALUE) count2++;
            }
            else{
                count2 = Integer.MAX_VALUE;
            }
            
             if(tops[i] == num2){
                
            }
            else if(bottoms[i] == num2){
                if(count3 != Integer.MAX_VALUE) count3++;
            }
            else{
                count3 = Integer.MAX_VALUE;
            }
            
            if(bottoms[i] == num2){
                
            }
             else if(tops[i] == num2){
                if(count4 != Integer.MAX_VALUE) count4++;
            }
            
            else{
                count4 = Integer.MAX_VALUE;
            }
        }
        int res = Math.min(count1,Math.min(count2,Math.min(count3,count4)));
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
}