class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n= nums.length;
        int freq[]= new int[1001];

        for(int arr[]: nums){
            for(int elem: arr){
                freq[elem]++;
            }
        }

        List<Integer> ans= new ArrayList<>();
        for(int i=1; i<1001; i++){
            if(freq[i]== n){
                ans.add(i);
            }
        }
        return ans;
    }
}