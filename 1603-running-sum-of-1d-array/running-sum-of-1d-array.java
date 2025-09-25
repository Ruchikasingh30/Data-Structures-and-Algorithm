class Solution {
    public int[] runningSum(int[] arr) {
        int result[] = new int[arr.length];
        int n= arr.length;
        int sum=0;
        result[0]=arr[0];
        for(int i=1; i<n ; i++){
            for(int j=0 ; j<=i ; j++){
                sum = arr[j]+sum;
            }
            result[i]=sum;
            sum=0;
        }
        return result;
    }
}