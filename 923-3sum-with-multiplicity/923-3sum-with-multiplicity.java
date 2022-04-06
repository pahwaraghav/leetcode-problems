class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long count = 0;
        for(int i=0; i<arr.length;i++){
            int num1 = arr[i];
            int targetSum = target - num1;
            HashMap<Integer,Integer> hmap = new HashMap<>();
            for(int j=i+1;j<arr.length;j++){
                int num = arr[j];
                int desiredNum = targetSum - num;
                if(desiredNum <0){
                    continue;
                }
                if(hmap.containsKey(desiredNum)){
                    count += hmap.get(desiredNum);
                }
                hmap.put(num,hmap.getOrDefault(num,0)+1);
            }
        }
        int res =(int)(count % (1e9 + 7));
        return res;
    }
}