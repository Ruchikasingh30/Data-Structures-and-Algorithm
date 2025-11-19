class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set= new HashSet<>();
        for(int elem: nums){
            set.add(elem);
        }
        while(set.contains(original)){
            original*=2;
        }
        return original;
    }
}