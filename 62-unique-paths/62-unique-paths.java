class Solution {
    public int uniquePaths(int m, int n) {
        int num = m + n -2;
        int r = m-1;
        double res = 1;
        for(int i=1; i<=r; i++){
            res = res * (num - r + i) /i;
        }
        return (int) res;
    }
}