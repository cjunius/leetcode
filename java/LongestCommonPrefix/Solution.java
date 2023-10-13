class Solution {
    public String longestCommonPrefix(String[] strs) {

        //Guard Clauses
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        //Find Min String length
        int minLen = strs[0].length();
        for(int i=1; i<strs.length; i++) {
            int len = strs[i].length();
            if (len == 0) return "";
            if (len < minLen) minLen = len;
        }

        //Compare Strings 1 char at a time
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<minLen; i++) {
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if(strs[j].charAt(i) != c) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }

}
