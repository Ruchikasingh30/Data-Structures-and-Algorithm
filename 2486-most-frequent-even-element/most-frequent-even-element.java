class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of even numbers only
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int maxfreq = 0;
        int minelem = -1; 

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            int elem = entry.getKey();

            if (freq > maxfreq || (freq == maxfreq && elem < minelem)) {
                maxfreq = freq;
                minelem = elem;
            }
        }

        return minelem;
    }
}
