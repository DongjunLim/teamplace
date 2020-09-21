# 별거 아닌거같은데 푸는데 오래 걸렸다.

class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        N = len(nums)
        max_arr = []
        min_arr = []

        max_arr.append(nums[0])
        min_arr.append(nums[0])
        answer = nums [0]

        for i in range(1,N):
            if nums[i] > 0:
                max_arr.append(max(nums[i], max_arr[i-1] * nums[i]))
                min_arr.append(min(nums[i], min_arr[i-1] * nums[i]))
            else:
                max_arr.append(max(nums[i], min_arr[i-1] * nums[i]))
                min_arr.append(min(nums[i], max_arr[i-1] * nums[i]))

        answer = max(max_arr)
        
        return answer



        