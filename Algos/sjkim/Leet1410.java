class Solution {
    public String entityParser(String text) {
        return text.replaceAll("&quot;","\"")
            .replaceAll("&apos;","'")
            .replaceAll("&gt;",">")
            .replaceAll("&lt;","<")
            .replaceAll("&frasl;","/")
            .replaceAll("&amp;","&");
        
        /* 순서 문제 => "&amp;gt; */
        /*return text.replaceAll("&quot;","\"")
            .replaceAll("&apos;","'")
            .replaceAll("&amp;","&")
            .replaceAll("&gt;",">")
            .replaceAll("&lt;","<")
            .replaceAll("&frasl;","/");
        */
    }
}