class Solution {
    public boolean isPalindrome(int x) {

        if(x<0) return false;
        if(x<10) return true;

        int rev=x%10;
        if(rev==0) return false;
        x=x/10;

        while(x>rev) {
            rev=rev*10+x%10;
            x=x/10;
        }
        return rev==x || rev/10==x;
    }
}
