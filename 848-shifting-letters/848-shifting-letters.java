class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        for(int i=shifts.length-2; i>=0;i--){
            shifts[i] = (shifts[i] + shifts[i+1])%26;
        }
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length;i++){
            int n = chars[i] - 'a';
            n = (n + shifts[i]) %26;
            char ch = (char) (n + 'a');
            chars[i] = ch;
        }
        return new String(chars);
    }
}