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
    public List<Integer> answer = new ArrayList<>();
    
    public void inorder(TreeNode root){
        if(root == null) return;
        if(root.left != null)
            inorder(root.left);
        answer.add(root.val);
        if(root.right != null)
            inorder(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return answer;
    }
}