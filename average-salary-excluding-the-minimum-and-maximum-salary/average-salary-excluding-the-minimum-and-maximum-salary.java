class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for(int val : salary){
            sum += val;
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        sum -= min + max;
        return sum * 1.0 / (salary.length-2);
    }
}