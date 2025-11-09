class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half [low...mid] is sorted
            if (nums[low] <= nums[mid]) {
                // Target is in the sorted left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    // Target must be in the right half
                    low = mid + 1;
                }
            } 
            
            // The right half [mid...high] must be sorted
            else { 
                // Target is in the sorted right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    // Target must be in the left half
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
}