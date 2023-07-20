class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        HashMap<String, Integer> hmap = new HashMap<>();
        for(int[] dominoe: dominoes) {
            Arrays.sort(dominoe);
            String str = Arrays.toString(dominoe);
            if(hmap.containsKey(str)) {
                count += hmap.get(str);
                hmap.put(str, hmap.get(str)+1);
            }
            else {
                hmap.put(str, 1);
            }
        }
        return count;
    }
}