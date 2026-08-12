class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb= new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        String og=sb.toString();
        sb.reverse();

        return sb.toString().equals(og);
    }
}