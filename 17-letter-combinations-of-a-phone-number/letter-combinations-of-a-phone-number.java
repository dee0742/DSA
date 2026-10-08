class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0){
            return ans;
        }
        String[] map = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };
        solve(0, digits, "", ans, map);
        return ans;
    }
    private void solve(int index, String digits, String path, List<String> ans, String[] map){
        if(index == digits.length()){
            ans.add(path);
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);

            solve(index + 1, digits, path + ch, ans, map);
        }
    }
}