class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : arr) {
            // Check if double exists OR if half exists
            // We check before adding the current number
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            // Add the current number to the set for future checks
            set.add(num);
        }
        
        return false;
    }
}