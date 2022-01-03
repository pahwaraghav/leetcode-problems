class Solution {
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer> hset = new HashSet<Integer>();
        for(int i=0; i<trust.length;i++){
            hset.add(trust[i][0]);
        }
        int judge = -1;
        for(int i=1; i<=n; i++){
            if(!hset.contains(i)){
                if(judge == -1){
                    judge = i;
                }
                else{
                    return -1;
                }
            }
        }
        if(judge == -1) return judge;
        
        for(int i=0; i<trust.length;i++){
            int person = trust[i][0];
            if(hset.contains(person) && trust[i][1] == judge){
                hset.remove(person);
            }
        }
        return hset.isEmpty() ? judge : -1;
    }
}