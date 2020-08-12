# Runtime: 96 ms
# Memory Usage: 15.9 MB

# nums를 한바퀴 돌면서 최대 도달할수 있는 인덱스를 확인하는 방식으로 복잡도는 O(n) 입니다.


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 1:
            return True
        
        goal = len(nums)-1
        
        # list 길이가 1 일땐 True
        if goal == 0:
            return True
        
        # 최대 도달할 수 있는 index
        avail_idx = 0
        

        for i in range(goal):
            # 현재 index에서 도달할 수 있는 최대 index
            jump_idx = i + nums[i]

            # 도달할 수 있는 최대 index 갱신
            avail_idx = max(avail_idx, jump_idx)
            
            # index가 목표보다 크거나 같을 때 True
            if avail_idx >= goal:
                    return True
            # 도달가능 최대 index와 현재 확인하는 index가 겹치고 에서 jump가 0일때 False
            if avail_idx == i and nums[avail_idx] == 0:
                return False
                
            # 도달가능 index 가 현재 확인하는 index 보다 작을때 False
            if avail_idx < i:
                return False
            