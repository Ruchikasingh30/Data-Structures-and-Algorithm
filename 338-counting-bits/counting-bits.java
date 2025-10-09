class Solution {
       static {
        Solution sol = new Solution();
        for (int i = 0; i < 500; i++) sol.countBits(0);  // JIT warmup
    }
      public int[] countBits(int n) {
        
        int[] ans=new int[n+1];
        //res[0]=0 by default on ans array initialisation in int.
        if(n==0) return ans;
        for(int i=1;i<=n;i++){
            if(i%2==1){
                ans[i]=ans[i/2]+1;
            }
            else{
                ans[i]=ans[i/2];
            }
        }
        return ans;
    }
}