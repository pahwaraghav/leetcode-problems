class Solution {
    public int countBinarySubstrings(String s) {
        ArrayList<Integer> groups = new ArrayList<Integer>();
        groups.add(1);
        for(int i=1; i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                groups.set(groups.size()-1,groups.get(groups.size()-1) + 1);
            }
            else{
                groups.add(1);
            }
        }
        int res = 0;
        for(int i=1;i<groups.size();i++){
            res += Math.min(groups.get(i-1), groups.get(i));
        }
        return res;
    }
}