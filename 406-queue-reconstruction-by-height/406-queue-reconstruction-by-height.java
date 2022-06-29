class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(b[0],a[0]);
        });
        for(int[] person: people){
            System.out.println(Arrays.toString(person));
        }
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);       
        }
        return res.toArray(new int[people.length][]);
    }
}