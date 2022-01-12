class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        final int TARGET = 60;
        for(int i=0; i<time.length;i++){
            time[i] = time[i]%60;
        }
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        hmap.put(0,0);
        int count = 0;
        for(int i=0; i<time.length;i++){
            int val = time[i];
            if(val == 0){
                count += hmap.get(val);
                hmap.put(val,hmap.get(val)+1);
                continue;
            }
            if(hmap.containsKey(TARGET-val)){
                count += hmap.get(TARGET-val);
            }
            if(hmap.containsKey(val)){
                hmap.put(val,hmap.get(val)+1);
            }
            else{
                hmap.put(val,1);
            }
        }
        return count;
    }
}