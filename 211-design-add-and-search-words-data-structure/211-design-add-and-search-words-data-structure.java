class Node{
    Node[] nlist;
    boolean flag;
    Node(){
        nlist = new Node[26];
        flag = false;
    }
    public void put(char ch, Node n){
        nlist[ch-'a'] = n;
    }
    public Node get(char ch){
        return nlist[ch-'a'];
    }
    public boolean containsKey(char ch){
        return nlist[ch-'a'] != null;
    }
    public void setFlag(boolean val){
        flag = val;
    }
    public boolean getFlag(){
        return flag;
    }
}

class WordDictionary {
    
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node temp = root;
        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            if(!temp.containsKey(ch)){
                temp.put(ch,new Node());
            }
            temp = temp.get(ch);
        }
        temp.setFlag(true);
    }
    
    public boolean search(String word) {
        ArrayList<Node> potentialNodes = new ArrayList<>();
        potentialNodes.add(root);
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            ArrayList<Node> newNodes = new ArrayList<>();
            if(ch == '.'){
                for(int j=0; j<26; j++){
                    char c = (char) (j + 'a');
                    for(Node n: potentialNodes){
                         if(n.containsKey(c)){
                            newNodes.add(n.get(c));
                        }  
                    }
                    
                }
            }
            else{
                for(Node n: potentialNodes){
                    if(n.containsKey(ch)){
                        newNodes.add(n.get(ch));
                    }  
                }
            }
            potentialNodes = newNodes;
        }
        for(Node n: potentialNodes){
            if(n.getFlag()){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */