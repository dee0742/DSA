class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int n = graph.length;
       int[] vis = new int[n];
       int[] pathVis = new int[n];
       int[] check = new int[n];

       for(int i = 0; i < n; i++){
           if(vis[i] == 0){
               dfs(i, graph, vis, pathVis, check);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(check[i] == 1){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean dfs(int node, int[][] graph, int[] vis, int[] pathVis, int[] check) {

        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for (int neighbor : graph[node]) {
            if (vis[neighbor] == 0) {
                if (dfs(neighbor, graph, vis, pathVis, check)) {
                    return true;
                }
            } else if (pathVis[neighbor] == 1) {
                return true;
            }
        }

        check[node] = 1;
        pathVis[node] = 0;

        return false;
    }
}