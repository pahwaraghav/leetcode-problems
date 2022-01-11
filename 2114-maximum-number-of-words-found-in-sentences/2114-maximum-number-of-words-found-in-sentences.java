class Solution {
    public int mostWordsFound(String[] sentences) {
        int count = 0;
        for(int i=0; i<sentences.length;i++){
            count = Math.max(count,countWords(sentences[i]));
        }
        return count;
    }
    public static int countWords(String sentence){
        int count = 0;
        int i=1;
        while(i < sentence.length()){
            if(sentence.charAt(i) == ' ' ){
                if(sentence.charAt(i-1) == ' ') i++;
                else{count++;i++;}
            }
            else{
                i++;
            }
        }
        if(sentence.charAt(sentence.length()-1) != ' '){
            count++;
        }
        return count;
    }
}