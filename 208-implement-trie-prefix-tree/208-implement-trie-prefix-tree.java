class Node{
    Node[] nlist;
    boolean flag;
    Node(){
        nlist = new Node[26];
        flag = false;
    }
    
    public Node get(char ch){
        return nlist[ch-'a'];
    }
    public void insert(char ch, Node n){
        this.nlist[ch-'a'] = n;
    }
    public boolean containsKey(char ch){
        return this.nlist[ch-'a'] != null;
    }
    public void setFlag(boolean val){
        this.flag = val;
    }
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!temp.containsKey(ch)){
                temp.insert(ch,new Node());
            }
            temp = temp.get(ch);
        }
        temp.setFlag(true);
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!temp.containsKey(ch)){
                return false;
            }
            temp = temp.get(ch);
        }
        return temp.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i=0; i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!temp.containsKey(ch)){
                return false;
            }
            temp = temp.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */