class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> hset = new HashSet<>();
        hset.add('a');
        hset.add('e');
        hset.add('i');
        hset.add('o');
        hset.add('u');
        int curr = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(i<k){
                if(hset.contains(ch)) curr++;
                max = Math.max(max, curr);
            }
            else{
                if(hset.contains(s.charAt(i-k))) curr--;
                if(hset.contains(ch)) curr++;
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}