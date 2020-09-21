"""
1. 문제접근
	리스트를 순회하며, 0을 만나면 삭제하고
	리스트 뒤에 0을 삽입했습니다.

2. 성능
	Runtime: 44ms
	Memory Usage: 15.1MB
	시간복잡도: O(N)
"""
from collections import deque

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:

        ret = nums.copy()
        length = len(nums)
        cnt = 0
        for i in range(length):
            if ret[i] == 0:
                del nums[i-cnt]
                cnt += 1
                nums.append(0)

        return nums
