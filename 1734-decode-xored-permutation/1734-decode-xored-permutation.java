class Solution {
    public int[] decode(int[] encoded) {
        int xor1ton = 0;
        for(int i=1;i<=encoded.length+1;i++){
            xor1ton = xor1ton ^ i;
        }
        int xorEven = 0;
        for(int i=0; i<encoded.length;i+=2){
            xorEven = xorEven ^ encoded[i];
        }
        int lastEle = xor1ton ^ xorEven;

        int[] arr = new int[encoded.length + 1];
        arr[arr.length -1] = lastEle;

        for(int i=arr.length-2; i>=0; i--){
            arr[i] = encoded[i] ^ arr[i+1];
        }
        return arr;
    }
}