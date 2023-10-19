//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
class Solution {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStrCustom(String haystack, String needle) {

        if(haystack.equals(needle)) return 0;

        char[] haystackCA = haystack.toCharArray();
        char[] needleCA = needle.toCharArray();
        int needleLen = needle.length();

        for(int i=0; i<haystack.length()-needleLen+1; i++) {
            if(needleCA[0] == haystackCA[i]) {
                boolean match = true;
                for(int j=0; j<needleLen; j++) {
                    if(haystackCA[i+j] != needleCA[j]) {
                        match = false;
                        break;
                    }
                }
                if(match) {
                    return i;
                }
            }
        }

        return -1;
    }
}
