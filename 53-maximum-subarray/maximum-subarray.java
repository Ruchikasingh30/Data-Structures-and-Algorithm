class Solution {
    public int maxSubArray(int[] arr) {
     int currsum=0, maxsum= Integer.MIN_VALUE;
        // for(int val: arr){
        //     currsum+=val;
        for(int i=0;i<arr.length;i++){
            currsum+= arr[i];
            maxsum= Math.max(currsum,maxsum);
            if(currsum<0){
                currsum=0;
            }
        }
        return maxsum;
    }
}
//using kadane's algo