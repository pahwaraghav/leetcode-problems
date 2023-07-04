public class Codec {

    String key = "~-~=";

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.size(); i++) {
            if(i!= strs.size()-1) {
                sb.append(strs.get(i)+key);
            }
            else {
                sb.append(strs.get(i));
            }
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] strArr = s.split(key, -1);
        List<String> ans = new ArrayList<>();
        for(String str: strArr) {
            ans.add(str);
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));