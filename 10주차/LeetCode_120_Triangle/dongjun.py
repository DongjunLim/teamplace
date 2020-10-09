'''
1. 문제접근
    동적계획법으로 풀었습니다.
    각 인덱스에서 왼쪽 위 숫자와 오른쪽 위 숫자를 더했을 때를 비교하여
    최솟값을 누적해 저장하는 방식으로 계산한 후,
    마지막행에서 최솟값을 찾아 반환했습니다.

2. 성능
     Runtime: 60ms
     MemoryUsage: 14.7MB
     Time complexity: O(N), N = total element
'''
class Solution:
    
    '''
    input param: [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
    '''
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        INF = 999999999
        length = len(triangle)
        
        for i in range(1, length):
            for j in range(len(triangle[i])):
                left = triangle[i-1][j-1] if j != 0 else INF
                right = triangle[i-1][j] if j != len(triangle[i])-1 else INF
                
                triangle[i][j] = min(left, right) + triangle[i][j]
        
        return min(triangle[length-1])
