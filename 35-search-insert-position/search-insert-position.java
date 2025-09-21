class Solution {
    public int searchInsert(int[] arr, int target) {
        if(target>arr[arr.length-1]) return arr.length;
        int index=-1;
        for(int i=0; i<arr.length;i++){
            if(arr[i]==target) return i;
            else if(arr[i]>target && index==-1) index=i;
    }
    return index;
}
}