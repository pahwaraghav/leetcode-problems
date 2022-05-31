class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hset = new HashSet<>();
        if(s.length()-k <0) return false;
        for(int i=0; i<=s.length()-k;i++){
            hset.add(s.substring(i,i+k));
        }
        return hset.size() == (1 << k);
    }
}