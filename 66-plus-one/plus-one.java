class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse from last digit to first
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            // If no carry, return immediately
            if (digits[i] != 0) return digits;
        }
        
        // If all digits were 9, the result is a 1 followed by n zeros
        int[] result = new int[n + 1];
        result[0] = 1; // leading 1, rest are zeros by default
        return result;
    }
}