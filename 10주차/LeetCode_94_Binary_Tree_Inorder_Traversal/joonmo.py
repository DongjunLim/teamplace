# Inorder Traversal 정의대로 사용
# 참고 페이지
# http://ejklike.github.io/2018/01/09/traversing-a-binary-tree-2.html

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        answer = []
        
        def _in_order_traversal(root):
            if root is None:
                pass
            else:
                _in_order_traversal(root.left)
                answer.append(root.val)
                _in_order_traversal(root.right)
        _in_order_traversal(root)
        
        return answer
