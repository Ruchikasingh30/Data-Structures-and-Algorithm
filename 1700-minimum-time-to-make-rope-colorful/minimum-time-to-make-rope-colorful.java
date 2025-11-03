class Solution {
    public int minCost(String colors, int[] neededtime) {
        int sum = 0;
        int mintime = neededtime[0];
        
        for (int i = 1; i < neededtime.length; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Add the smaller needed time to sum
                sum += Math.min(mintime, neededtime[i]);
                // Keep the bigger needed time for the next comparison
                mintime = Math.max(mintime, neededtime[i]);
            } else {
                // Reset mintime when color changes
                mintime = neededtime[i];
            }
        }
        
        return sum;
    }
}
