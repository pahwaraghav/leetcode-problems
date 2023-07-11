class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        for(int[] preq : prerequisites) {
            if(!hmap.containsKey(preq[1])) hmap.put(preq[1], new ArrayList<>());
            hmap.get(preq[1]).add(preq[0]);
            degrees[preq[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] order = new int[numCourses];
        int i=0;
        addZeroIndegrees(degrees, q);
        while(!q.isEmpty()) {
            int val = q.poll();
            order[i++] = val;
            List<Integer> dependents = hmap.getOrDefault(val, new ArrayList<>());
            for(int dependent : dependents) {
            degrees[dependent]--;
            }
            addZeroIndegrees(degrees, q);
        }
        if(i != numCourses) return new int[]{};
        return order;
    }

    public void addZeroIndegrees(int[] degrees, Queue<Integer>q) {
        for(int i=0; i<degrees.length; i++) {
            if(degrees[i] == 0) {
                q.offer(i);
                degrees[i] = -1;
            }
        }
    }
}