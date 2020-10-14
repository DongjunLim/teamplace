# 리스트 한바퀴돌면서 현재까지 common prefix와 새로운 단어의 common prefix를 구해서 새로 업데이트 한다.
# O(N) 

# 두단어 common prefix 구하는 함수
def CommonPrefix(a, b):
    prefix = ''

    len_a, len_b = len(a), len(b)

    if len_a > len_b:
        for idx in range(len_b):
            if a[idx] == b[idx]:
                prefix += b[idx]
            else:
                break    
    else:
        for idx in range(len_a):
            if a[idx] == b[idx]:
                prefix += a[idx]
            else:
                break
    return prefix

class Solution(object):    
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        
        N = len(strs)
        if N == 0:
            return ''
        if N == 1:
            return strs[0]
        
        else:
            prefix = CommonPrefix(strs[0], strs[1])
            for idx in range(1, N):
                prefix = CommonPrefix(strs[idx], prefix)
                # print(prefix)

            return prefix
            
        
