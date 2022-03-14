class Solution {
    public String simplifyPath(String path) {
        ArrayList<String> paths = new ArrayList<String>();
        
        String curr = "";
        
        for(int i=1; i<path.length();i++){
            char ch = path.charAt(i);
            
            if(ch == '/' &&  path.charAt(i-1) == '/'){
                continue;
            }
            
            if(ch == '/'){
                
                if(curr.equals(".")){
                    curr="";
                    continue;
                }
                
              
                
                if(curr.equals("..")){
                    if(paths.size() == 0){
                        curr="";
                        continue;
                    }
                    paths.remove(paths.size()-1);
                    curr="";
                    continue;
                }
                
                if(!curr.equals("")){
                    paths.add(curr);
                    curr = "";
                }
                continue;
            }
            curr += ch;
        }
        
        if(!curr.equals("")){
            if(curr.equals(".")){
                
            }
            else if(curr.equals("..")){
                if(paths.size()!=0){
                      paths.remove(paths.size()-1);
                }
             
            }
            else{
                paths.add(curr);
            }
        }
        
        String res = "/";
        
        System.out.println(paths);
        for(int i=0; i<paths.size(); i++){
            res += paths.get(i);
            if(i != paths.size()-1){
                res += "/";
            }
        }
        return res;
    }
}