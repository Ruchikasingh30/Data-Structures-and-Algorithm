class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int maxans=0;
        
        int left=0;
        int right= n-1;

        while(left<right){

            int w= right-left;
            int h= Math.min(height[right], height[left]);
            int area= w * h;

            maxans= Math.max(area,maxans);

           if(height[left]< height[right])left++;
           else right--;
        }
        return maxans;
    }
}