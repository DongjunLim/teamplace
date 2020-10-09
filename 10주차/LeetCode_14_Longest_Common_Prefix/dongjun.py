'''
1. 문제접근
    가장 문자배열의 차이가 나는 두 문자열을 골라
    접두사의 길이를 1부터 차례로 비교해가며
    비교 문자열이 다를 경우 그 전까지의 문자열을 반환하도록 짰습니다.
    
2. 성능
    Runtime: 20ms
    Memory Usage: 14MB
    Time Complexity: O(N)
'''
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        
        ret = ""
        
        str1 = min(strs)
        str2 = max(strs)
        
        for x, y in zip(str1, str2):
            if x == y:
                ret += x
            else:
                break
        
        return ret
