/**
 *  @문제접근
 *  후위순회로 트리를 순회하며 노드의 왼쪽, 오른쪽 서브트리의
 *  최대합을 구하고, 각각의 모든 합들 중 최대 값을 answer에 저장합니다.
 *
 *  @성능
 *  Runtime: 0 ms
 *  Memory Usage: 41.6 MB
 */
public class BinaryTreeMaximumPathSum {
    public static final int NULL = Integer.MIN_VALUE;
    public static int answer;
    public int maxPathSum(TreeNode root) {
        answer = Integer.MIN_VALUE;
        calcPathSum(root);
        return answer;
    }

    public int calcPathSum(TreeNode current){
        if(current == null)
            return NULL;

        int leftSubTreeSum = Math.max(0, calcPathSum(current.left));
        int rightSubTreeSum = Math.max(0, calcPathSum(current.right));
        int sumVal = current.val + leftSubTreeSum + rightSubTreeSum;

        answer = Math.max(answer, sumVal);

        return Math.max(leftSubTreeSum, rightSubTreeSum) + current.val;
    }
}

