class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maxl = 0;
        int res = 0;
        for (int num : nums) {
            int value = 1;
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, value);
            } else {
                value = hashMap.get(num) + 1;
                hashMap.put(num, value);
            }
            maxl = Math.max(maxl, value);
        }
        for(int value : hashMap.values()) {
            if (value == maxl) {
                res += value;
            }
        }
        return res;
    }
}