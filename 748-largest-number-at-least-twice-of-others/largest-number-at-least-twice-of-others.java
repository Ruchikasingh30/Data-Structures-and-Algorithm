class Solution {
    public int dominantIndex(int[] arr) {
        int k=0;
        for(int i=0; i<arr.length; i++){
            if (arr[k]<arr[i]) k=i;
        }
        for(int i=0; i<arr.length;i++){
            if(k!=i &&arr[k]< arr[i]*2) return -1;
        }
        return k;
        
    }
}