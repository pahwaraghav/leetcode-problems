class Solution {
    public int maxProduct(String[] words) {
        int[] bitWords = new int[words.length];
        for(int i=0; i<words.length;i++){
            String word = words[i];
            int[] arr = new int[26];
            for(int j=0; j<word.length();j++){
                char ch = word.charAt(j);
                arr[ch - 'a'] = 1;
            }
            int num = 0;
            for(int j=0; j<26;j++){
                if(arr[j] == 1) num = num | 1;
                num = num << 1;
            }
            bitWords[i] = num;
        }
        int ans = 0;
        for(int i=0; i<bitWords.length;i++){
            for(int j=i+1; j<bitWords.length;j++){
                if((bitWords[i] & bitWords[j]) == 0){
                    ans = Math.max(ans,words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}