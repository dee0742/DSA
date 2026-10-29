class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            boolean[] vis = new boolean[n + 1];

            if(dfs(u, v, adj, vis)){
                return edge;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }
    boolean dfs(int node, int target, List<List<Integer>> adj, boolean[] vis){
        if (node == target) return true;

        vis[node] = true;

        for(int neighbor : adj.get(node)){
            if(!vis[neighbor]){
                if(dfs(neighbor, target, adj, vis)){
                    return true;
                }
            }
        }
        return false;
    }
}