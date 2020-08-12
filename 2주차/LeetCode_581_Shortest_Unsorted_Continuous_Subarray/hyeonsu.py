#Runtime: 204 ms
#Memory Usage: 15 MB
#O(N)

class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        num = sorted(nums)
        start_check = False
        point = [0, -1]
        
        for idx in range(len(nums)):
            if nums[idx] != num[idx]:
                if not start_check:
                    start_check = True
                    point[0] = idx
                else:
                    point[1] = idx
        
        if point[1] == -1: return 0
        return point[1] - point[0] + 1
