class Solution {
    public int smallestNumber(int n) {
        for (int x = n; ; x++) {
            if ((x & (x + 1)) == 0) {
                return x;
            }
        }
    }
}
