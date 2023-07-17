class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2 != 0) return new int[]{};
        Arrays.sort(changed);
        System.out.println(Arrays.toString(changed));
        HashMap<Integer,Integer> hmap = new HashMap<>();
        List<Integer> lis = new ArrayList<>();
        for(int val: changed) {
            if(val%2 == 0 &&  hmap.containsKey(val/2) && hmap.get(val/2) != 0) {
                lis.add(val/2);
                hmap.put(val/2, hmap.get(val/2)-1);
            }
            else {
                hmap.put(val, hmap.getOrDefault(val,0)+1);
            }
        }
        for(Map.Entry<Integer,Integer> e : hmap.entrySet()) {
            if(e.getValue() != 0) return new int[] {};
        }
        int[] ans = new int[lis.size()];
        int i=0;
        for(int val: lis) {
            ans[i++] = val;
        }
        return ans;
    }
}