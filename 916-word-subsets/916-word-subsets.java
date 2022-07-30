class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] arr = new int[26];
        for(String word : words2){
            int[] curr = new int[26];
            for(int i=0; i<word.length();i++){
                char ch = word.charAt(i);
                curr[ch-'a']++;
            }
            for(int i=0; i<arr.length;i++){
                arr[i] = Math.max(arr[i], curr[i]);
            }
        }
        for(String word : words1){
            int[] curr = new int[26];
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                curr[ch-'a']++;
            }
            boolean flag = true;
            for(int i=0; i<arr.length; i++){
                if(curr[i] < arr[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans.add(word);
            }
        }
        return ans;
    }
}