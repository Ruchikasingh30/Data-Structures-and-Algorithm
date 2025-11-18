class Solution {
    public void reverseString(char[] s) {
        reverseHelper(s, 0, s.length - 1);
    }

    private void reverseHelper(char[] s, int left, int right) {
        if (left >= right) {
            return; // Base case: pointers have met or crossed
        }
        // Swap characters at left and right indices
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // Recur for the inner substring
        reverseHelper(s, left + 1, right - 1);
    }
}
