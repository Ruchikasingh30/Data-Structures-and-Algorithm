class Solution {
    public boolean isPalindrome(int x) {
        int a=x;
        int rev=0;
        while(a>0){
            int rem=a%10;
            rev=10*rev+rem;
            a=a/10;
        }
        if(x==rev) return true;
        else return false;
    }
}