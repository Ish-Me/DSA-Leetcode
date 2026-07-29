class Pair{
    String word;
    int steps;
    Pair(String word,int steps){
        this.word=word;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(int i = 0;i<wordList.size();i++){
            set.add(wordList.get(i));
        } 
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.remove();
            if(word.equals(endWord)==true)return steps;
            for(int j=0;j<word.length();j++){
                for(char ch = 'a';ch <='z';ch++){
                    char[] temp = word.toCharArray();
                    temp[j]=ch;
                    String repWord = new String(temp);
                    if(set.contains(repWord)==true){
                        set.remove(repWord);
                        q.add(new Pair(repWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}