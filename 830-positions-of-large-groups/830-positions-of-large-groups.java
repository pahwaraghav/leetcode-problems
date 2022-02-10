class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        
        int start = 0;
        for(int i=1; i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                continue;
            }
            else{
                int diff = i - start;
                if(diff >=3){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(start);
                    temp.add(i-1);
                    arr.add(temp);
                }
                start = i;
            }
        }
        if(s.length() - start >=3){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(s.length()-1);
            arr.add(temp);
        }
        return arr;
    }
}