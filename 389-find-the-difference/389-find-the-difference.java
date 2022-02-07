class Solution {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            int num = ch - 'a';
            arr[num]++;
        }
        for(int i=0; i<t.length();i++){
            char ch = t.charAt(i);
            int num = ch - 'a';
            arr[num]--;
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == -1){
                char ch = (char) ('a' + i);
                return ch;
            }
        }
        return '0';
    }
}