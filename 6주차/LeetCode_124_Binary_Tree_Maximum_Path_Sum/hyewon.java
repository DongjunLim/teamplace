class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Leetcode124_Binary_Tree_Maximum_Path_Sum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    public int traverse(TreeNode root){

        if(root == null) return 0;

        int left = Math.max(0,traverse(root.left));
        int right = Math.max(0,traverse(root.right));
        int sum = root.val + left + right;

        maxSum = Math.max(maxSum , sum);

        return root.val + Math.max(left, right);
    }
}
