class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int n= arr.length; 
        int count=0;
        int maxcount=0;

        for(int num:arr){
            if(num==1){
                count++;
                maxcount=Math.max(count,maxcount);
            }
            else count=0;
        }
        return maxcount;
    }
}