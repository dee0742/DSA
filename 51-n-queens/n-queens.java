class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(board[i] , '.');
        }
        backtrack(0, board, ans);
        return ans;
    }
    private void backtrack(int row, char[][] board, List<List<String>> ans){
        if(row == board.length){
            List<String> current =  new ArrayList<>();

        for(char[] r : board){
            current.add(new String(r));
        }
        ans.add(current);
        return;
    }
    for(int col = 0; col < board.length; col++){
        if(isSafe(board, row, col)){
            board[row][col] = 'Q';
            backtrack(row+1, board, ans);
            board[row][col] = '.';
        }
    }
}
private boolean isSafe(char[][] board, int row, int col){
    int n = board.length;

    for(int i = 0; i < row; i++){
        if(board[i][col] == 'Q'){
            return false;
        }
    }
    for(int i = row - 1, j = col - 1; i >= 0 && j >= 0;
    i--, j--){
        if(board[i][j] == 'Q'){
            return false;
        }
    }
    for(int i = row - 1, j = col + 1; i >= 0 && j < n;
    i--, j++){
        if(board[i][j] == 'Q'){
            return false;
        }
    }
    return true;
}
}