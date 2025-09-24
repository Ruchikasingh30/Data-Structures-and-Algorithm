class Solution {
    public int minOperations(int[] arr) {
        int operations = 0;
        int prev = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= prev) {
                int needed = prev + 1 - arr[i];
                operations += needed;
                arr[i] = prev + 1;
            }
            prev = arr[i];
        }
        
        return operations;
    }
}
