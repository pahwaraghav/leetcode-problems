class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hset = new HashSet<>();
        for(int num: arr){
            if(hset.contains(num * 2) || (num%2 == 0 && hset.contains(num/2))){
                return true;
            }
            hset.add(num);
        }
        return false;
    }
}