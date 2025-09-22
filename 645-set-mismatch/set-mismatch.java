class Solution {
    public int[] findErrorNums(int[] nums){
        int n = nums.length;
        int[] result = new int[2]; 

        // We need a way to detect duplicate and missing numbers
        // One way is to use a count array or marking visited
        // Here, we'll use a frequency array

        int[] freq = new int[n + 1];

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) {
                result[0] = i;  // Duplicate number
            } else if (freq[i] == 0) {
                result[1] = i;  // Missing number
            }
        }
        return result;
    }
}
