class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // Check lsb
            count += (n & 1);
            // lrs for next bit
            n = n >>> 1;
        }
        return count;
    }
}