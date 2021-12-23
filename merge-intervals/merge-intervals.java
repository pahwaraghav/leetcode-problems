class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        ArrayList<int[]> mergedArrayList = new ArrayList<int[]>();
        mergedArrayList.add(intervals[0]);
        for(int i=1; i<intervals.length;i++){
            int[] interval = mergedArrayList.get(mergedArrayList.size()-1);
            if(intervals[i][0] <= interval[1]){
                interval[1] = Math.max(interval[1],intervals[i][1]);
            }
            else{
                mergedArrayList.add(intervals[i]);
            }
        }
        int[][] res = new int[mergedArrayList.size()][2];
        for(int i=0; i<mergedArrayList.size();i++){
            res[i] = mergedArrayList.get(i);
        }
        return res;
    }
}