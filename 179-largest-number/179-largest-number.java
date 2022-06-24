class Solution {
    public String largestNumber(int[] nums) {
        String[] sNums = new String[nums.length];
        for(int i=0; i<nums.length;i++){
            sNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sNums,(s1,s2)-> {
            String str1 = s2 + s1;
            return str1.compareTo(s1 + s2);
        });
        
        if(sNums[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s: sNums){
            sb.append(s);
        }
        return new String(sb);
    }
}