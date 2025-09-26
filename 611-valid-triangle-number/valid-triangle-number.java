class Solution {
    public int triangleNumber(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int count=0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    int  a= arr[i], b=arr[j], c=arr[k];
                    if(a+b>c) count++;
                }
            }
        }
        return count;
    }
}