# Runtime: 192 ms
# Memory Usage: 13.7 MB

# 정방향 역방향으로 한바퀴씩 돌아서 순서가 어긋난 양끝을 구해서 구했습니다.

class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        curr_max = -float('inf')
        curr_min = float('inf')
        
        idx1 = -1
        idx2 = -1
        
        # 정방향으로 갔을시 현재 최대값보다 작은 값 존재할때 그 index 저장
        for idx, val in enumerate(nums):
            if curr_max < val:
                curr_max = val
            elif val < curr_max:
                idx1 = idx
                
        # 역방향으로 갔을시 현재 최솟값보다 큰 값 존재할때 그 index 저장
        for idx, val in enumerate(nums[::-1]):
            if curr_min > val:
                curr_min = val
            elif curr_min < val:
                idx2 = idx
                
        print(idx1)        
        print(idx2)
        
        # 순이 틀린 index 가 존재하지 않을시 없으므로 return 0
        if idx1 == -1:
            return 0
        
        return len(nums) - (2*len(nums) -idx2 -idx1) + 2