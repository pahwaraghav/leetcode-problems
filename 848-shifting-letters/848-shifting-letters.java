class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        for(int i=shifts.length-1; i>=0;i--){
            if(i!=shifts.length-1){
                shifts[i] = (shifts[i] + shifts[i+1])%26; 
            }
            int n = chars[i] - 'a';
            n = (n + shifts[i]) %26;
            char ch = (char) (n + 'a');
            chars[i] = ch;
        }

        return new String(chars);
    }
}