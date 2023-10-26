// https://leetcode.com/problems/length-of-last-word
class Solution {
    public int lengthOfLastWord(String s) {

        int len = 0;
        for(int i=s.length() -1; i>=0; i--) {
            //skip trailing spaces
            if(s.charAt(i) != ' ') {
                //start count at first letter
                len++;
            } else {
                //once count has begun, if a space is found immediately return the count
                if(len > 0) return len;
            }
        }

        // if no space is found, return the count
        return len;
    }
}
