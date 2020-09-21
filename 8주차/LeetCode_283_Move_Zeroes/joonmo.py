# 0의 개수 세주고
# 0의 개수만큼 0빼주고 맨뒤에 넣어준다

class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        
        N = len(nums)
        cnt = 0
        zero_num = nums.count(0)

        for _ in range(zero_num):
            nums.remove(0)
            nums.append(0)

        print(nums)

        


