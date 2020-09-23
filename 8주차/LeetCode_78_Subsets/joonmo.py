# 파이썬은 말이 필요없다.

from itertools import combinations

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        N = len(nums)
        answer = []

        for i in range(N + 1):
            answer.extend(list(combinations(nums,i)))

        return [list(i) for i in answer]
        