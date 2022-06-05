class Solution {
      Set<Integer> col = new HashSet<Integer>();
      Set<Integer> diag1 = new HashSet<Integer>();
      Set<Integer> diag2 = new HashSet<Integer>();

      public int totalNQueens(int n) {
        int[] res = new int[1];
        helper(res,n,0);
        return res[0];
      }
      public void helper(int[] res, int n, int row){
        if(row==n){
            res[0]++;
        }
        else{
            for(int i=0; i<n; i++){
                if(col.contains(i) || diag1.contains(i+row) || diag2.contains(row-i)) continue;
                else{
                    col.add(i);
                    diag1.add(i+row);
                    diag2.add(row-i);
                    helper(res,n,row+1);
                    col.remove(i);
                    diag1.remove(i+row);
                    diag2.remove(row-i);
                }
             }
          }
       }
    
}