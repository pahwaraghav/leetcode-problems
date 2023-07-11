class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        for(int[] preq: prerequisites) {
            if(!hmap.containsKey(preq[1])) hmap.put(preq[1], new ArrayList<>());
            hmap.get(preq[1]).add(preq[0]);
            degrees[preq[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] order = new int[numCourses];
        int i =0;
        addZeroDegrees(degrees, q);
        while(!q.isEmpty()) {
            int course = q.poll();
            order[i++] = course;
            List<Integer> lis = hmap.get(course);
            if(lis == null) continue;
            for(int val: lis) {
                degrees[val]--;
            }
            addZeroDegrees(degrees, q);
        }
        return i == numCourses;
    }
    public void addZeroDegrees(int[] degrees, Queue<Integer> q) {
        for(int i=0; i<degrees.length; i++) {
            if(degrees[i] == 0) {
                q.offer(i);
                degrees[i]--;
            }
        }
    }
}