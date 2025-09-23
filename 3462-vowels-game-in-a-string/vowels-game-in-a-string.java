class Solution {
    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                return true;
            }
        }
        // no vowel found
        return false;
    }

    private boolean isVowel(char c) {
        // assume lowercase; if uppercase can adjust
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
