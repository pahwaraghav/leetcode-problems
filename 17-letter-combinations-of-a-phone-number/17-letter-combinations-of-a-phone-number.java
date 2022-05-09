class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> arr = new ArrayList<>();
        if(digits.equals("")) return arr;
        StringBuilder sbr = new StringBuilder();
        HashMap<Integer,String> hmap = buildHashMap();
        helper(digits,0,hmap,sbr,arr);
        return arr;
    }
    public void helper(String digits, int i, HashMap<Integer,String> hmap, StringBuilder sbr, List<String> res){
        if(i == digits.length()){
            res.add(new String(sbr));
            return;
        }
        int num = digits.charAt(i) - '0';
        String chars = hmap.get(num);
        for(int j=0; j<chars.length();j++){
            char ch = chars.charAt(j);
            sbr.append(ch);
            helper(digits,i+1,hmap,sbr,res);
            sbr.deleteCharAt(sbr.length()-1);
        }
    }
    public HashMap<Integer,String> buildHashMap(){
        HashMap<Integer,String> hmap = new HashMap<>();
        hmap.put(2,"abc");
        hmap.put(3,"def");
        hmap.put(4,"ghi");
        hmap.put(5,"jkl");
        hmap.put(6,"mno");
        hmap.put(7,"pqrs");
        hmap.put(8,"tuv");
        hmap.put(9,"xywz");
        return hmap;
    }
}