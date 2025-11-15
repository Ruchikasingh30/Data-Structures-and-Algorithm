class Solution {
    public int numberOfSubstrings(String s) {
       int n = s.length();
        if (n == 0) {
            return 0;
        }

        // B is the maximum number of zeros a valid substring can have.
        int maxZeros = (int) Math.sqrt(n);
        long dominantCount = 0;

        // Store indices of all zeros. Add boundary markers at -1 and n
        // to simplify calculations for '1'-only blocks at ends.
        List<Integer> zeroIndices = new ArrayList<>();
        zeroIndices.add(-1); // Boundary before the string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeroIndices.add(i);
            }
        }
        zeroIndices.add(n); // Boundary after the string

        // 1. Count substrings with z = 0 zeros (all '1's)
        // These exist in the gaps between consecutive zero indices.
        for (int p = 0; p < zeroIndices.size() - 1; p++) {
            // Find the start and end of the '1'-only block
            int blockStart = zeroIndices.get(p) + 1;
            int blockEnd = zeroIndices.get(p + 1) - 1;
            
            // Calculate the length of the '1'-only block
            long blockLength = blockEnd - blockStart + 1;

            if (blockLength > 0) {
                // A block of length L has L*(L+1)/2 substrings.
                // All have z=0, ones >= 1.
                // The condition ones >= z*z becomes ones >= 0, which is always true.
                dominantCount += blockLength * (blockLength + 1) / 2;
            }
        }

        // 2. Count substrings with z >= 1 and z <= maxZeros
        for (int z = 1; z <= maxZeros; z++) {
            
            // We need at least z+2 elements in zeroIndices to form a
            // substring with z zeros (e.g., [-1, z1, n] for z=1).
            if (z + 1 >= zeroIndices.size()) {
                // Not enough zeros in the whole string to make z zeros.
                break;
            }

            // We need the substring length `len = j-i+1` to satisfy:
            // ones = len - z
            // ones >= z*z
            // len - z >= z*z
            // len >= z*z + z
            // j - i + 1 >= z*z + z
            // j - i >= z*z + z - 1
            int requiredDiff = z * z + z - 1;

            // A substring with `z` zeros spans `z+1` gaps in zeroIndices.
            // It starts in gap `p` (between z[p] and z[p+1])
            // It contains zeros z[p+1]...z[p+z]
            // It ends in gap `p+z` (between z[p+z] and z[p+z+1])
            for (int p = 0; p + z + 1 < zeroIndices.size(); p++) {
                
                // Valid start indices `i` are from z[p]+1 to z[p+1]
                int i_start = zeroIndices.get(p) + 1;
                int i_end = zeroIndices.get(p + 1);

                // Valid end indices `j` are from z[p+z] to z[p+z+1]-1
                int j_start = zeroIndices.get(p + z);
                int j_end = zeroIndices.get(p + z + 1) - 1;

                // Now, count pairs (i, j) in these ranges
                // that satisfy j - i >= requiredDiff (or j >= i + requiredDiff)
                
                // This inner loop is O(length of '1's block).
                // The sum of all (i_end - i_start) over all `p` is O(n).
                // Total complexity is O(z * n), and z goes up to sqrt(n).
                // So, O(n * sqrt(n)).
                for (int i = i_start; i <= i_end; i++) {
                    // For a fixed i, we need j >= i + requiredDiff
                    // We also need j >= j_start
                    int j_lower_bound = Math.max(j_start, i + requiredDiff);

                    // Count valid j's from j_lower_bound to j_end
                    if (j_lower_bound <= j_end) {
                        dominantCount += (j_end - j_lower_bound + 1);
                    }
                }
            }
        }

        return (int)dominantCount;
    }
}