"""
1. 문제접근
	dfs로 가능한 모든 순열을 만들었습니다.

2. 성능
	Runtime: 28ms
	Memory Usage: 14.2MB
	시간복잡도: O(N!)
"""

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.ret = []
        visited = set()
        
        self.dfs(0, nums, [], visited)
        
        return self.ret
        
    
    def dfs(self, idx, nums, now, visited):
        if len(now) == len(nums):
            self.ret.append(now.copy())
            return
        
        for i, x in enumerate(nums[idx:]):
            if x not in visited:
                now.append(x)
                visited.add(x)
                self.dfs(idx + i, nums, now.copy(), visited)
                del now[-1]
                visited.remove(x)
        
        self.ret.append(now)
