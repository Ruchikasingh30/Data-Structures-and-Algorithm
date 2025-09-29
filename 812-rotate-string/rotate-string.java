class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String doubled = s + s; //concats the string.
        
        int g = goal.length();
        for (int i = 0; i <= doubled.length() - g; i++) {
            int j = 0;
            while (j < g && doubled.charAt(i + j) == goal.charAt(j)) {
                j++;
            }
            if (j == g) {
                return true;
            }
        }
        return false;
    }
}
