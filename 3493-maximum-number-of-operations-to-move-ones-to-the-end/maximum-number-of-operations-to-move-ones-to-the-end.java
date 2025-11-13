public class Solution {
    public int maxOperations(String s) {
        int operations = 0;
        int onesCount = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            } 
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') {
                operations += onesCount;
            }
        }
        return operations;
    }
}
