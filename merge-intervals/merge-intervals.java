class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        List<int[]> arr = new ArrayList<int[]>();
        arr.add(intervals[0]);
        for(int i=1; i<intervals.length;i++){
            int[] interval = arr.get(arr.size()-1);
            if(interval[1] >= intervals[i][0]){
                interval[1] = Math.max(interval[1],intervals[i][1]);
            }
            else{
                arr.add(intervals[i]);
            }
        }
        int[][] res = new int[arr.size()][2];
        for(int i=0; i<arr.size();i++){
            res[i] = arr.get(i);
        }
        return res;
    }
}