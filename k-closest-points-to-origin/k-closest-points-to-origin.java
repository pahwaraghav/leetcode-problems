class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>((a,b) -> Double.compare(b.distanceFromOrigin, a.distanceFromOrigin));
        for(int[] point : points) {
            int x = point[0];
            int y = point[1];
            double distanceFromOrigin = Math.sqrt(x*x + y*y);
            if(pq.size() < k) {
                pq.offer(new Point(x, y, distanceFromOrigin));
            }
            else {
                Point old = pq.peek();
                if(!pq.isEmpty() && old.distanceFromOrigin > distanceFromOrigin) {
                    pq.poll();
                    pq.offer(new Point(x, y, distanceFromOrigin));
                }
            }
        }
        int[][] res = new int[k][2];
        int i=0;
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            res[i++] = new int[]{p.x,p.y};
        }
        return res;
    }
}

class Point {
    int x;
    int y;
    double distanceFromOrigin;
    Point() {}
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Point(int x, int y, double distanceFromOrigin) {
        this.x = x;
        this.y = y;
        this.distanceFromOrigin = distanceFromOrigin;
    }
}