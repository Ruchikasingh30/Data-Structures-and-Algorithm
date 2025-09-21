class Solution {
    public int maxProduct(int[] arr) {
        int maxproduct= 0;
        for(int i=0;i<arr.length;i++){
            for( int j=i+1;j<arr.length;j++){
                int product= (arr[i]-1)*(arr[j]-1);
                maxproduct= Math.max(maxproduct,product);
            }
        }
        return maxproduct;
    }
}