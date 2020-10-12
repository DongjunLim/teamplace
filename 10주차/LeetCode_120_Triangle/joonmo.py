# triangle 모양의 dp 생성
# O(n^2)
# 입력 [[2],[3,4],[6,5,7],[4,1,8,3]]
# dp [[2], [5, 6], [11, 10, 13], [15, 11, 18, 16]]

class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        
        N = len(triangle)
        
        dp = [[] for _ in range(N)]
        dp[0].append(triangle[0][0])
              
        for row in range(1,N):
            for idx in range(row+1):
                if idx == 0:
                    dp[row].append(triangle[row][idx] + dp[row-1][idx])
                elif idx == row:
                    dp[row].append(triangle[row][idx] + dp[row-1][idx-1])
                else:
                    if idx == 0:
                        dp[row].append(min(left, right))
                    else:
                        left = triangle[row][idx] + dp[row-1][idx-1]
                        right = triangle[row][idx] + dp[row-1][idx]
                    dp[row].append(min(left, right))
            # print(dp)
        return min(dp[-1])