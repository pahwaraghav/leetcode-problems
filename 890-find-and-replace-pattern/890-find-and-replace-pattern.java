class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for(String word : words){
            int[] arr = new int[26];
            Arrays.fill(arr,-1);
            if(pattern.length() != word.length()){
                continue;
            }
            int j = 0;
            int count = 0;
            for(int i=0; i<pattern.length(); i++){
                char ch1 = pattern.charAt(i);
                char ch2 = word.charAt(j++);
                if(arr[ch1-'a'] == -1){
                    arr[ch1-'a'] = ch2 - 'a';
                    count++;
                }
                else{
                    char ch = (char) (arr[ch1-'a'] + 'a');
                    if(ch == ch2){
                        count++;
                    }
                }
            }
            if(count != word.length()){
                continue;
            }
            HashSet<Integer> hset = new HashSet<>();
            boolean flag = true;
            for(int i=0; i<arr.length;i++){
                if(arr[i] == -1) continue;
                if(hset.contains(arr[i])){
                    flag = false;
                    break;
                }
                hset.add(arr[i]);
            }
            if(flag){
                ans.add(word);
            }
        }
        return ans;
    }
}