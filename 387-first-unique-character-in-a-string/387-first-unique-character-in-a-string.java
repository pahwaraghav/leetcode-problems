class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hset = new HashMap<>();
        for(int i=0; i<s.length();i++){
            hset.put(s.charAt(i),hset.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0; i<s.length();i++){
            if(hset.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}