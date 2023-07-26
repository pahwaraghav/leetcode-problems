class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(dist.length > Math.ceil(hour)) {
            System.out.println("EARLY");
            return -1;
        }
        int low = 1;
        int high = Integer.MAX_VALUE;
        for(int val: dist) high = Math.max(high,val);
        int ans = high;
        while(low <= high) {
            int mid = low + (high - low)/2;
            double time = calcTime(dist, mid);
            if(time <= hour) {
                ans = mid;
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public double calcTime(int[] dist, int speed) {
        double ans = 0;
        for(int i=0; i<dist.length; i++) {
            double time = dist[i] * 1.0 / speed;;
            ans += i == dist.length -1 ? time : Math.ceil(time);
        }
        return ans;
    }
}