class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0,1}};
    public List<String> findWords(char[][] board, String[] words) {
        Node head = makeTrie(words);
        HashSet<String> hset = new HashSet<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                helper(board, head, i, j, hset);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String str : hset) {
            ans.add(str);
        }
        return ans;
    }

    public void helper(char[][] board, Node head, int i, int j, HashSet<String> ans) {
        char ch = board[i][j];
        if(ch=='.' || head.chars[ch-'a'] == null) return;

        if(head.chars[ch-'a'].isEnding) {
            ans.add(head.chars[ch-'a'].word);
        }
        board[i][j] = '.';

        for(int[] dir: dirs) {
            int newI = i+dir[0];
            int newJ = j+dir[1];
            if(isValid(board, newI, newJ)) {
                helper(board, head.chars[ch-'a'], newI, newJ, ans);
            }
        }
        board[i][j] = ch;
    }
    public boolean isValid(char[][] board, int i, int j) {
        if(i<0 || j<0 || i>=board.length || j>= board[0].length) return false;
        if(board[i][j]=='.') return false;
        return true;
    }

    public Node makeTrie(String[] words) {
        Node head = new Node();
        for(String word: words) {
            Node temp = head;
            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);
                if(temp.chars[ch-'a'] == null) {
                    temp.chars[ch-'a'] = new Node();
                }
                temp = temp.chars[ch-'a'];
            }
            temp.isEnding = true;
            temp.word = word;
        }
        return head;
    }
}

class Node {
    Node[] chars;
    boolean isEnding;
    String word;
    Node() {
        chars = new Node[26];
    }
    Node(boolean isEnding) {
        chars = new Node[26];
        this.isEnding = isEnding;
    }
}