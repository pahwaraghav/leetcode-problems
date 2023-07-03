class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int[] freq = new int[26];
        int[] freq2 = new int[26];
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i)-'a']++;
            freq2[s.charAt(i) - 'a']++;
            freq2[goal.charAt(i) - 'a']--;
            if(s.charAt(i) != goal.charAt(i)) count++;
        }
        boolean flag = false;
        for(int i=0; i<freq.length; i++) {
            if(freq[i] > 1) flag = true;
            if(freq2[i] != 0) return false;
        }
        if(s.equals(goal) && flag) return true;
        return count == 2;
    }
}