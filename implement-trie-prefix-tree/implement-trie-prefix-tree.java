class Trie {

    Node head;

    public Trie() {
        head = new Node();
    }
    
    public void insert(String word) {
        Node temp = head;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(temp.chars[ch-'a'] == null) {
                temp.chars[ch-'a'] = new Node();
            }
            temp = temp.chars[ch-'a'];
        }
        temp.isEnding = true;
    }
    
    public boolean search(String word) {
        Node temp = head;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(temp.chars[ch-'a'] == null) return false;
            temp = temp.chars[ch-'a'];
        }
        return temp.isEnding;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = head;
        for(int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(temp.chars[ch-'a'] == null) return false;
            temp = temp.chars[ch-'a'];
        }
        return true;
    }
}

class Node {
    Node[] chars;
    boolean isEnding;
    Node() {
        chars = new Node[26];
    }
    Node(boolean isEnding) {
        chars = new Node[26];
        this.isEnding = isEnding;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */