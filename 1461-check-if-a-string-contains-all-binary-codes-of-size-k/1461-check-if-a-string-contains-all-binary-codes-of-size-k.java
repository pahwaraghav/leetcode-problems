class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hset = new HashSet<>();
        StringBuilder sbr = new StringBuilder();
        for(int i=0; i<k && i<s.length();i++){
            sbr.append(s.charAt(i));
        }
        for(int i=k; i<s.length();i++){
            String curr = new String(sbr);
            hset.add(curr);
            sbr.deleteCharAt(0);
            sbr.append(s.charAt(i));
        }
        hset.add(new String(sbr));
        return hset.size() == (1 << k);
    }
}