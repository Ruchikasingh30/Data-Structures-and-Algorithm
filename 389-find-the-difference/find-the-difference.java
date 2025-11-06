class Solution {
    public char findTheDifference(String s, String t) {
        int[] charCounts = new int[26];
    
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (charCounts[i] == -1) {
                return (char) (i + 'a');
            }
        }
        
        return ' ';
    }
}