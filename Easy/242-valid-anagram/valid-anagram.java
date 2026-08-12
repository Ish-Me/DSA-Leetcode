class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int[] alphas = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphas[s.charAt(i)-'a']++;
            alphas[t.charAt(i)-'a']--;
        }
        for (int x : alphas) {
            if (x != 0) return false;
        }
        return true;
    }
}