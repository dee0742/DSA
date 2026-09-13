class Solution {
    class TrieNode {
        TrieNode[] childern = new TrieNode[26];
        String word = null;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            insert(word);
        }
        List<String> result = new ArrayList<>();

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board,i,j,root,result);
            }
        }
        return result;
    }
    private void insert(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(curr.childern[index] == null){
                curr.childern[index] = new TrieNode();
            }
            curr = curr.childern[index];
        }
        curr.word = word;
    }
    private void dfs(char[][]board, int row, int col, TrieNode node,List<String> result){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return;
        }
        char ch = board[row][col];
        if(ch == '#'){
            return;
        }
        int index = ch - 'a';

        if(node.childern[index] == null){
            return;
        }
        TrieNode next = node.childern[index];
        if(next.word != null){
            result.add(next.word);

            next.word = null;
        }
        board[row][col] = '#';

        dfs(board, row + 1, col, next, result);
        dfs(board, row - 1, col, next, result);
        dfs(board, row, col + 1, next, result);
        dfs(board, row, col - 1, next, result);

        board[row][col] = ch;
    }
}