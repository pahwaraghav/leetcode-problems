class Solution {
    public String removeDuplicates(String s, int k) {
        char[] res = s.toCharArray();
        int i = 0;
        for(int j=0; j<s.length();j++,i++){
            res[i] = res[j];
            if(i>0 && res[i] == res[i-1]){
                int count = 1;
                for(int x=i; x>=1;x--){
                    if(res[x] == res[x-1]){
                        count++;
                    }
                    else{
                        break;
                    }
                }
                if(count == k){
                    i-=count;
                }
            }
        }
        return new String(res,0,i);
    }
}