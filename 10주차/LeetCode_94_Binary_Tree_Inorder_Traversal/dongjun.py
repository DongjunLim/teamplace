'''
1. 문제접근
    중위순회를 재귀적으로 구현해 풀었습니다.
    
2. 성능
    Runtime: 24ms
    Memory Usage: 14.1MB
    Time Complexity: O(N)
'''
class Solution:
    ret = []
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        self.ret = []
        
        return self.inorder(root)
    
    def inorder(self, node):
        if node is None:
            return self.ret
        
        self.inorder(node.left)
        self.ret.append(node.val)
        self.inorder(node.right)
        
        return self.ret
