import java.util.*;

class Solution {
    public boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>(Arrays.asList(words)); 
        int i = 1;
        while (i < res.size()) {
            if (checkAnagram(res.get(i - 1), res.get(i))) {
                res.remove(i);  
            } else {
                i++;
            }
        }
        return res;
    }
}