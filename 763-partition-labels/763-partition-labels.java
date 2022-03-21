class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            arr[ch-'a'] = i;
        }
        
        int lastOcc = 0;
        int start = 0;
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            lastOcc = Math.max(lastOcc,arr[ch-'a']);
            if(lastOcc == i){
                list.add(lastOcc-start+1);
                start = lastOcc+1;
            }
        }
        return list;
    }
}