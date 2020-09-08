from itertools import permutations

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # 파이썬 permutation 사용
        permute = permutations(nums, len(nums))
        return permute