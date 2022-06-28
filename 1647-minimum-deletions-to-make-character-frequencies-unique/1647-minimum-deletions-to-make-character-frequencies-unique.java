class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        int ans = 0;
        Arrays.sort(freq);
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0; i<freq.length;i++){
            int val = freq[i];
            if(!hset.contains(val)){
                hset.add(val);
                continue;
            }
            while(val > 0){
                if(!hset.contains(val)){
                    break;
                }
                ans++;
                val--;
            }
            if(val !=0) hset.add(val);
        }
        return ans;
    }
}