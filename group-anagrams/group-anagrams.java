class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<List<String>>();
        HashMap<String,List<String>> hmap = new HashMap<String,List<String>>();
        for(int i=0; i<strs.length; i++){
            String st = sortString(strs[i]);
            if(hmap.containsKey(st)){
                List<String> ls = hmap.get(st);
                ls.add(strs[i]);
            }
            else{
                List<String> ls = new ArrayList<String>();
                ls.add(strs[i]);
                hmap.put(st,ls);
            }
        }
        for(Map.Entry m: hmap.entrySet()){
            System.out.println(m.getKey() + " : " + m.getValue());
            List<String> ls = hmap.get(m.getKey());
            anagrams.add(ls);
        }
        return anagrams;
    }
    public String sortString(String str){
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}