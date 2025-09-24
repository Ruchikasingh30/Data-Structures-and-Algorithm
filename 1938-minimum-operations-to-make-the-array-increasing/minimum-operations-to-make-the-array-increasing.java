class Solution {
    public int minOperations(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]) continue;
            else{
                int toadd = arr[i]-arr[i+1]+1;
                arr[i+1] = toadd +arr[i+1];
                sum= sum+toadd;
            }
        }
        return sum;
    }
}