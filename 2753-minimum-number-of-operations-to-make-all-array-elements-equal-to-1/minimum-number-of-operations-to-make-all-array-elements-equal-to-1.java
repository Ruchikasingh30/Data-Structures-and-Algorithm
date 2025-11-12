class Solution {
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int countOnes = 0;
        for (int num : nums) {
            if (num == 1) countOnes++;
        }
        if (countOnes > 0) {
            // Already have some 1s
            return n - countOnes;
        }

        int minLen = Integer.MAX_VALUE;
        // Find shortest subarray with gcd 1
        for (int i = 0; i < n; i++) {
            int g = 0;
            for (int j = i; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        if (minLen == Integer.MAX_VALUE) return -1;  // No subarray with gcd 1

        // Steps: to create one '1' + spread to other elements
        return n - 1 + (minLen - 1);
    }
}
