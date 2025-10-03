class Solution {
    public boolean containsDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for(int num: arr){
            if(set.contains(num)) return true;
            else set.add(num);
        }
        return false;
    }
}