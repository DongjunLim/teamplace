/*
SubTree의 가장 큰 합을 return하는 문제
SubTree가 가지고 있는 node의 개수는 최소 1개 최대 3개이다.

후위 순회(left -> right -> root)
Tree의 root에서 내려갈수 있는 곳 까지 내려간다.
leaf node를 만났을 경우 node가 가지고 있는 value값을 return한다.
left node에서 return된 값과 right node에서 return된 값, 그리고 root의 값을 더하여 최댓값을 찾는다.

단순히 3개의 node.value을 더하여 최댓값을 찾는 문제로 생각했으나,
3개의 node중 음수가 존재하는 경우를 고려해야 했기때문에
마지막 leaf node까지 내려가서 하나의 node만으로 해당값이 최댓값인지를 검사해야 했다.

Time Complexity: O(N)
Space Complexity: O(N)
 */

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
