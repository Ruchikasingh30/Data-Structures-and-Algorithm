class Solution {
    public int strStr(String hay, String needle) {
        int h= hay.length();
        int n= needle.length();

        for(int i=0; i<h-n+1; i++){      //haystack loop
            for(int j=0; j<n; j++){  //needle loop
                if(hay.charAt(i+j) != needle.charAt(j)) break;
                if(j== n-1) return i;
            }
        }
        return -1;
    }
}