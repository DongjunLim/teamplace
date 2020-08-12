# Runtime: 108 ms, faster than 43.29% of Python3 online submissions for Jump Game.
# Memory Usage: 15.9 MB, less than 29.41% of Python3 online submissions for Jump Game.

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        pos = 0  # 포인터

        # 오른쪽 기준만 바라보면 됌
        while True:
            # 이동한 위치가 0만 존재하면 종료
            if nums[pos] == 0 and len(nums) != 1:
                return False
            # 이동한 위치에서 끝을 이동할 수 있으면 종료
            if len(nums) <= (nums[pos] + pos + 1):
                return True
            
            # 시작, 끝 위치를 지정
            start, end = pos + 1, pos + nums[pos] + 1
            # 오른쪽에서 최대 value와 index를 찾음
            max_, idx_ = -1, -1
                
            # 이동 위치는 찾는 범위중에 오른쪽의 번호일 수록 상대적인 위치 value를 더해줘서 계산 
            # [ 3, 4, 1, 2 ]  범위가 좁혀지면 [ 3+1, 4+2, 1+3, 2+4 ] -> [ 4, 6, 4, 6 ] 상대적인 위치도 고려해서 최대 value 구할 것   
            for idx, num in enumerate(nums[start : end]):
                if max_ <= num + idx:
                    max_ = num + idx
                    idx_ = idx + start
            # 포인터 재갱신
            pos = idx_
