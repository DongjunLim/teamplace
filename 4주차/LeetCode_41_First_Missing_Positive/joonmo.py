# Runtime: 32 ms
# Memory Usage: 13.8 MB

# 1부터 시작해서 nums안에 숫자가 존재시 1씩 더해준다.

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        minimum = 1

        while True:
            if minimum in nums:
                minimum += 1
            else:
                break
        
        return minimum