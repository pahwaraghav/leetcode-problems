public class Codec {
    HashMap<String,String> hmap = new HashMap<>();
    static int start = 10000;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hashed = start + "";
        start++;
        hmap.put(hashed,longUrl);
        return hashed;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hmap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));