class Solution {
    public String getHint(String secret, String guess) {
        int n=secret.length();
        int bull = 0;
        int cow = 0;

        boolean[] usedsecret = new boolean[n];
        boolean[] usedguess = new boolean[n];

        for(int i=0;i<n;i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bull++;
                usedsecret[i]= true;
                usedguess[i]= true;
            }
        }

        for(int i=0;i<n;i++){
            if (!usedsecret[i]) {
                for(int j=0;j<n;j++){
                    if(!usedguess[j]&&secret.charAt(i)==guess.charAt(j)){
                        cow++;
                        usedguess[j]=true;
                        break;
                    }
                }
            }
        }
        return bull+"A"+cow+"B";
    }
}