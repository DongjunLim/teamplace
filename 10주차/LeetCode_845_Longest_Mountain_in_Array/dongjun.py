'''
1. 문제접근
    투포인터로 풀었습니다.

2. 성능
    Runtime: 164ms
    Memory Usage: 14.9MB
    Time Complexity: O(N)
'''

class Solution:
    def longestMountain(self, A: List[int]) -> int:
        
        i = 0
        answer = 0
        while i < len(A) - 1:
            
            j = i + 1
            visited_top = False
            
            while j < len(A):
                if A[j] > A[j-1]:
                    if visited_top:
                        break
                    
                if A[j] < A[j-1]:
                    if not visited_top:
                        if j - i == 1:
                            break
                        visited_top = True
                
                if A[j] == A[j-1]:
                    break
                j += 1

            if visited_top:
                if j - i > 2:
                    answer = max(answer, j - i)
                
                i = j - 1
                continue
            i = j
            
        return answer
