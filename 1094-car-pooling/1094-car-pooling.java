class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxTo = 0;
        for(int i=0; i<trips.length;i++){
            maxTo = Math.max(maxTo, trips[i][2]);
        }
        int[] arr = new int[maxTo + 1];
        
        for(int i=0; i<trips.length;i++){
            int j = trips[i][1];
            while(j<trips[i][2]){
                arr[j]+=trips[i][0];
                j++;
            }
        }
        for(int i=0; i<arr.length;i++){
            if(arr[i] > capacity) return false;
        }
        return true;
    }
}