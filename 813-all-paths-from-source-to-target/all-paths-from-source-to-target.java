class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(0, graph, path, ans);

        return ans;
    }
    private void dfs(int node, int[][]graph, List<Integer> path, List<List<Integer>> ans){
        path.add(node);

        if(node ==  graph.length-1){
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for(int neighbour : graph[node]){
            dfs(neighbour, graph, path, ans);
        }
        path.remove(path.size()-1);
    }
}