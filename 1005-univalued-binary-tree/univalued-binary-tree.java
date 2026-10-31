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
class Solution {
    public boolean isUnivalTree(TreeNode node){
        if(node == null){
            return true;
        }
        if(node.left != null && node.val != node.left.val){
            return false;
        }
        if(node.right != null && node.val != node.right.val){
            return false;
        }
        return isUnivalTree(node.left) && isUnivalTree(node.right);
    }
}