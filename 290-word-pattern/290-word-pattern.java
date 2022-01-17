class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split("\\s+");
        
        HashMap<Character, String> hmap = new HashMap<Character, String>();
        
        if(str.length != pattern.length()){
            return false;
        }
        
        for(int i=0; i<str.length;i++){
            char ch = pattern.charAt(i);
            String st = str[i];
            if(hmap.containsKey(ch)){
                if(!hmap.get(ch).equals(st)){
                    return false;
                }
            }
            else{
                if(hmap.containsValue(st)){
                    return false;
                }
                hmap.put(ch,st);
            }
        }
        return true;
    }
}