class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] arr = new int[26];
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }
        Arrays.sort(arr);
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] == 0){
                return true;
            }
            if(arr[i] != arr[i+1]) return false;
        }
        return true;
    }
}