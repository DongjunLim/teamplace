# Runtime: 44 ms
# Memory Usage: 13.5 MB

# Kandane's algorithm
# list를 돌면서 전 index까지의 최대합이 양수이면 현재값을 더해준다

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        for i in range(1, len(nums)):
            if nums[i-1] > 0:
                nums[i] += nums[i-1]
            # print(nums)
        return max(nums)



# runtime error
# import math
# length = len(nums)
# max_sum = math.isinf(neg_inf)
# for i in range(1, length + 1):
#     for j in range(length + 1 - i):
#         tmp_sum = sum(nums[j:j+i])
#         max_sum = max(max_sum, tmp_sum)

# return max_sum
