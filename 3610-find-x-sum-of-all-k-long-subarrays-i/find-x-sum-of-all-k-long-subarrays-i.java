class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        // The result array will have n - k + 1 elements
        int[] ans = new int[n - k + 1];
        
        // Iterate through the start of each window
        for (int i = 0; i <= n - k; i++) {
            
            // 1. Create a frequency map for the current window
            Map<Integer, Integer> freqMap = new HashMap<>();
            int currentWindowSum = 0;
            for (int j = i; j < i + k; j++) {
                freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
                currentWindowSum += nums[j]; // Also calculate total sum for edge case
            }
            
            // 2. Handle the edge case (fewer than x distinct elements)
            if (freqMap.size() < x) {
                ans[i] = currentWindowSum;
                continue;
            }
            
            // 3. Convert map entries to a list
            List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());
            
            // 4. Sort the list
            //     Sort by frequency (value) descending
            //     If frequencies are equal, sort by element (key) descending
            Collections.sort(entries, (a, b) -> {
                if (a.getValue() != b.getValue()) {
                    return b.getValue() - a.getValue(); // Descending frequency
                } else {
                    return b.getKey() - a.getKey();     // Descending value
                }
            });
            
            // 5. Get the top x elements into a Set for fast lookup
            Set<Integer> topXElements = new HashSet<>();
            for (int j = 0; j < x; j++) {
                topXElements.add(entries.get(j).getKey());
            }
            
            // 6. Calculate the final x-sum for the window
            int xSum = 0;
            for (int j = i; j < i + k; j++) {
                if (topXElements.contains(nums[j])) {
                    xSum += nums[j];
                }
            }
            
            // 7. Store the sum
            ans[i] = xSum;
        }
        
        return ans;
    }
}