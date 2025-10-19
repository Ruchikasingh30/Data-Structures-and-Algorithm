class Solution {
    public int mostFrequent(int[] nums, int key) {
        int n= nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<n-1; i++){
            if(nums[i]==key){
                map.put(nums[i+1], map.getOrDefault(nums[i+1],0)+1);
            }
        }
        int maxcount=0;
        int maxvalue=0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()> maxcount){
                maxcount= entry.getValue();
                maxvalue= entry.getKey(); 
            }
        }
        return maxvalue;
    }
}