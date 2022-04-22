import java.util.*;
class Solution {
    public String removeOccurrences(String s, String part) {
        Vector<Character> arr = new Vector<>();
        for(int i=0; i<s.length();i++){
            arr.add(s.charAt(i));
            if(arr.size()>=part.length()){
                boolean flag = true;
                int j=part.length()-1;
                for(int k=arr.size()-1;k>=0;k--){
                    if(j<0){
                        break;
                    }
                    if(arr.get(k) != part.charAt(j)){
                        flag = false;
                    }
                    j--;
                }
                if(flag){
                    arr.setSize(arr.size()-part.length());
                }
            }
        }
        String ans = "";
        for(int i=0; i<arr.size();i++){
            ans+=arr.get(i);
        }
        if(ans.equals(part)){
            return "";
        }
        return ans;
    }
}