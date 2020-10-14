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
    static ArrayList<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res=new ArrayList();
        if(root!=null)
        findInorder(root);
        return res;
    }
    static void findInorder(TreeNode root){
        
        if(root.left!=null)findInorder(root.left);
        res.add(root.val);
        if(root.right!=null)findInorder(root.right);
    }
}
