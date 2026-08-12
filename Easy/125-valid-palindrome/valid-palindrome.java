class Solution {
    public boolean isPalindrome(String s) {
        if(s.equals(" "))return true;
        String str = "";
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z' || ch>='0' && ch<='9')str+=ch;
        }
        if(str.equals(palindrome(str)))return true;
        return false;
    }
    private String palindrome(String s){
        String str = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            str=ch+str;
        }
        return str;
    }
}