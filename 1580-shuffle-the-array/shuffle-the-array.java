class Solution {
    public int[] shuffle(int[] nums, int n) {
        int l= nums.length;
        int[] result = new int[l];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }
        return result;
    }
}