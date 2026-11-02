import java.util.*;

class Pair {
    String first;
    int second;
    Pair(String first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        Set<String> st = new HashSet<>(wordList);
        st.remove(startWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int Steps = q.peek().second;
            q.remove();

            if(word.equals(targetWord)){
                return Steps;
            }

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, Steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}