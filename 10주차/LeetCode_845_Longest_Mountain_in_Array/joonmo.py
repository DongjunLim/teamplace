class Solution(object):
    def longestMountain(self, A):
        N = len(A)
        ans = base = 0

        while base < N:
            end = base
            # 증가하고있을떄
            if end + 1 < N and A[end] < A[end + 1]: 
                # 정상까지 계속 등산 하면서 end 갱신
                while end+1 < N and A[end] < A[end+1]:
                    end += 1
                
                # 증가하던 중 감소점이 나오면 정상 도달
                if end + 1 < N and A[end] > A[end + 1]: #if end is really a peak..
                    # 감소하면 계속 하산 하면서 end 갱신
                    while end+1 < N and A[end] > A[end+1]:
                        end += 1
                    # 산 찾으면 ans 갱신
                    ans = max(ans, end - base + 1)
                    # print(ans)
            
            # 산이 처음부터 존재하지않을시 base 증가시켜주고
            # 산이 존재했을시 산의 끝을 다시 base 로 시작
            base = max(end, base + 1)

        return ans