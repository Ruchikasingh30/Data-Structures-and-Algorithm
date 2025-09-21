class Solution{
    public int[] pivotArray(int[] arr, int pivot) {
        int n=arr.length;
        int j=0;
        int ans[]= new int [n];
        for(int i=0;i<n;i++){
            if(arr[i]<pivot){
                ans[j++]=arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]==pivot){
                ans[j++]=arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]>pivot){
                ans[j++]=arr[i];
            }
        }
        return ans;
    }
}
