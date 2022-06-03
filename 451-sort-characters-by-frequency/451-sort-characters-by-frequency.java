class Node{
    char ch;
    int val;
    Node(){}
    Node(char ch, int val){
        this.ch = ch;
        this.val = val;
    }
}
class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[62];
        for(int i=0; i<s.length();i++){
            char ch= s.charAt(i);
            freq[getIndex(ch)]++;
        }
        ArrayList<Node> arr = new ArrayList<>();
        for(int i=0; i<freq.length;i++){
            if(freq[i] !=0){
                arr.add(new Node(getChar(i),freq[i]));
            }
        }
        Collections.sort(arr,(a,b) -> b.val-a.val);
        StringBuilder sbr = new StringBuilder(s.length());
        for(int i=0; i<arr.size();i++){
            Node n = arr.get(i);
            for(int j=0; j<n.val;j++){
                sbr.append(n.ch);
            }
        }
        return new String(sbr);
    }
    public int getIndex(char ch){
        if(ch >='0' && ch <='9'){
            return ch - '0' + 52;
        }
        if(ch >='a' && ch <='z'){
            return ch - 'a' + 26;
        }
        return ch - 'A';
    }
    public char getChar(int i){
        if(i<26){
            return (char) ('A' + i);
        }
        if(i<52) return (char) ('a' + i - 26);
        return (char) ('0' + i - 52);
    }
}