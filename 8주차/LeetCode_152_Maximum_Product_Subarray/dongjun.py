"""
1. 문제접근
	동적계획법을 사용해 풀었습니다.
	각각의 최솟값과 최댓값을 모두 저장해
	음수 * 음수의 경우를 처리했습니다.

2. 성능
	Runtime: 60ms
	Memory Usage: 16.2MB
	시간복잡도: O(N)
	공간복잡도: O(N)
"""

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        MIN, MAX = 0, 1
        dp = [[1]*2 for _ in range(len(nums))]
        
        dp[0][MIN] = nums[0]
        dp[0][MAX] = nums[0]
        answer = nums[0]
        
        for i in range(1, len(nums)):
            dp[i][MIN] = min(dp[i-1][MAX]*nums[i], dp[i-1][MIN]*nums[i], nums[i])
            dp[i][MAX] = max(dp[i-1][MAX]*nums[i], dp[i-1][MIN]*nums[i], nums[i])
            
            answer = max(dp[i][MAX], answer)
        
        return answer
