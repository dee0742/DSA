/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class NodeValue{
    public int maxNode, minNode, sum;
    NodeValue(int minNode , int maxNode , int sum){
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.sum = sum;
    }
}
class Solution {
    int maxSum = 0;
    public NodeValue maxSumBSTHelper(TreeNode root) {
      if(root == null){
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
      }
      NodeValue left = maxSumBSTHelper(root.left);
      NodeValue right = maxSumBSTHelper(root.right); 

      if(left.maxNode < root.val && root.val < right.minNode){
        int currentSum = left.sum + right.sum + root.val;
        maxSum = Math.max(maxSum, currentSum);

        return new NodeValue(Math.min(root.val, left.minNode),Math.max(root.val, right.maxNode),currentSum);
      }
      return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,0);
    }
    public int maxSumBST(TreeNode root){
        maxSumBSTHelper(root);
        return maxSum;
    }
}