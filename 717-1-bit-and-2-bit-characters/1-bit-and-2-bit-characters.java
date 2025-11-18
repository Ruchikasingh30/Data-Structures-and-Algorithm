class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;
        while (i < n - 1) {
            if (bits[i] == 1) {
                //2 bit char
                i += 2;
            } else {
                // 1 bit char
                i += 1;
            }
        }
        // If we stopped at the last index, it means last char is 1-bit character
        return i == n - 1;
    }
}
