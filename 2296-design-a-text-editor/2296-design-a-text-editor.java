class TextEditor {
    StringBuilder sbr;
    int cursor;
    public TextEditor() {
        sbr = new StringBuilder();
        cursor = 0;
    }
    
    public void addText(String text) {
        sbr.insert(cursor,text);
        cursor += text.length();
    }
    
    public int deleteText(int k) {
        sbr = sbr.delete(Math.max(cursor-k,0),cursor);
        int deleted = cursor - k <0 ? cursor : k;
        cursor = cursor - deleted;
        return deleted;
    }
    
    public String cursorLeft(int k) {
        cursor = Math.max(cursor-k,0);
        return sbr.substring(Math.max(cursor-10,0),cursor);
    }
    
    public String cursorRight(int k) {
        cursor = Math.min(cursor+k,sbr.length());
        return sbr.substring(Math.max(cursor-10,0),cursor);
    }

}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */